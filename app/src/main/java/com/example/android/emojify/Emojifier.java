package com.example.android.emojify;


import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    private static final String LOG_TAG = Emojifier.class.getSimpleName();

    public static void detectFaces(Context context, Bitmap bitmap) {

        FaceDetector faceDetector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        SparseArray<Face> faceSparseArray = faceDetector.detect(frame);

        Log.v(LOG_TAG, "Number of faces detected: " + faceSparseArray.size());

        if (faceSparseArray.size() == 0) {
            Toast.makeText(context, "No face is detected", Toast.LENGTH_SHORT).show();
        }

        faceDetector.release();

    }

}
