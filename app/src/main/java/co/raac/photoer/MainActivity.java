package co.raac.photoer;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.media.effect.EffectFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.List;

//import ja.burhanrashid52.photoeditor.PhotoEditor;
//import ja.burhanrashid52.photoeditor.PhotoEditorView;
//import ja.burhanrashid52.photoeditor.PhotoFilter;

public class MainActivity extends Activity {

    private static final String TAG = "PhotoerMainActivity";
    private Class<EffectFactory> Field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: "+);
      //  PhotoEditorView mPhotoEditorView = findViewById(R.id.photoEditorView);
      //  mPhotoEditorView.getSource().setImageResource(R.drawable.got_s);
        java.lang.reflect.Field[] effects=EffectFactory.class.getDeclaredFields();
        LinearLayout ll=findViewById(R.id.ll);
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(0xFF00FF00); // Changes this drawbale to use a single color instead of a gradient
        gd.setCornerRadius(5);
        gd.setStroke(3, 0xFF000000);
        for (int i=0;i<effects.length;i++){
            final java.lang.reflect.Field effect=effects[i];
            if(effect.getName().contains("EFFECT")) {
                Button btn = new Button(this);
                btn.setWidth(240);
                btn.setHeight(240);
                btn.setText(effect.getName());
                btn.setBackground(gd);
                btn.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        adjustEffect(v, effect);
                    }
                });
                ll.addView(btn);
            }
        }

//        PhotoEditor mPhotoEditor = new PhotoEditor.Builder(this, mPhotoEditorView)
//                .setPinchTextScalable(true)
//                .build();
//        mPhotoEditor.setFilterEffect(PhotoFilter.BRIGHTNESS);
    }
    public void adjustEffect(View v,Field effect) {
        Toast.makeText(this,effect.getName(),Toast.LENGTH_SHORT).show();
        switch (v.getId()) {
        }
    }
}
