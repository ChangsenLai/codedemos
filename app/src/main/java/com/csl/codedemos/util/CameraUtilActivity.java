package com.csl.codedemos.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;

/**
 * a activity with camera util
 */
public abstract class CameraUtilActivity extends Activity {

    private static final int REQUEST_CODE_CAPTURE = 100;
    private static final int REQUEST_CODE_PHOTO = 101;

    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_CODE_CAPTURE) {
            onCameraResult(file);
        } else if (requestCode == REQUEST_CODE_PHOTO) {
            onPhotoResult(getPhotoPath(this, data.getData()));
        }
        file = null;
    }

    abstract void onCameraResult(File file);

    abstract void onPhotoResult(String filePath);

    /**
     * open camera (need permission)
     *
     * @param file which is used to image
     */
    void gotoCamera(File file) throws Exception {
        if (file == null) {
            throw new Exception("file is null obj");
        }
        if (!file.exists()) {
            throw new Exception("file is not exists");
        }
        this.file = file;
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
        startActivityForResult(intent, REQUEST_CODE_CAPTURE);
    }

    /**
     * open camera (need permission)
     */
    void gotoPhoto() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_CODE_PHOTO);
    }

    /**
     * open camera
     * @return path of image
     */
    private String getPhotoPath(Context context, Uri data) {
        if (data == null || TextUtils.isEmpty(data.toString())) {
            Log.w("CameraUtilActivity", "uri is null or uri data is empty");
            return null;
        }
        String path = null;
        String uri = data.toString();
        Log.i("CameraUtilActivity", "image uri:" + uri);
        if (uri.startsWith("content://")) {
            String[] proj = {MediaStore.Images.Media.DATA};
            Cursor cursor = context.getContentResolver().query(data, proj, null, null, null);
            if (cursor != null) {
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                path = cursor.getString(column_index);
                cursor.close();
            }
        } else if (uri.startsWith("file://")) {
            path = uri.substring("file://".length());
        }
        return path;
    }
}
