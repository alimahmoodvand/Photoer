package co.raac.photoer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.FileNotFoundException;

public class ImageActivity extends Activity {
    private static final String TAG = "PhotoerImageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Button btn_picker=findViewById(R.id.btn_picker);
        btn_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 1);
            }
        });
    }
    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            try {
                String realPath = ImageFilePath.getPath(ImageActivity.this, data.getData());
                Log.d(TAG, "onActivityResult: "+realPath);
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("realPath", realPath);
                startActivity(intent);
            } catch (Exception e) {
                Log.d(TAG, "onActivityResult: "+e.getMessage());
            }
        }else {
        }
    }
}
