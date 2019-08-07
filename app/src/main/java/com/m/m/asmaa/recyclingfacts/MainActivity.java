package com.m.m.asmaa.recyclingfacts;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //تعريف المتغيرات
        private TextView text;
        private Button btn;
    //هنعرف متغير نستخدم فيه الlog
        public static final String TAG ="TAG_FACT" ;
    private static final String FACT_key="fact_key";
    private String FACT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //تعيين المتغيرات

        text = (TextView) findViewById(R.id.fact_txtview);
        btn = (Button) findViewById(R.id.btn_get);
        final RecyclingfactGenerator recyclingfactGenerator=new RecyclingfactGenerator(this);
        FACT=getResources().getString(R.string.fact_text);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //هيتم تغيير الحقيقه
              //text.setText(fact);
                //علشان نجيب حقائق مختلفه
                FACT=recyclingfactGenerator.generateFacts();
                //الخطا كان علشان الي بره استرنج والي جوة انتجر الحل نحط دبل كوتيشن بلس الكونتعلشان نحولها استرنج
                text.setText(FACT);
                //هنا هعرف Toast
                //هنشيل النص ونروح نحطه في ال؟string fileبعدين نضيفه هنا عن طريق getResources().getString(R.string.btn_rest)ودي الفنكشن الي بنضيف بيها
                Toast.makeText(MainActivity.this,getResources().getString(R.string.btn_rest),Toast.LENGTH_SHORT).show();
                //هستخدم log
                Log.e(TAG,getResources().getString(R.string.log_app));

            }
        };
        btn.setOnClickListener(onClickListener);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString(FACT_key,FACT);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        FACT=savedInstanceState.getString(FACT_key);
        text.setText(FACT);

    }
}
