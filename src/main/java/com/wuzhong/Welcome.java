package com.wuzhong;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by wuzhong on 13-12-7.
 */
public class Welcome extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final View view = View.inflate(this, R.layout.welcome, null);
        setContentView(view);

        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.welcome);
        int[] pngs = {R.drawable.welcome, R.drawable.bg1, R.drawable.bg2};
        final Bg bg = new Bg(pngs);

        ((Button) this.findViewById(R.id.header_button_left)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int result = bg.getPrevis();
                if(result > 0){
                    Drawable drawable = getResources().getDrawable(result);
                    layout.setBackgroundDrawable(drawable);
                }
            }
        });

        ((Button) this.findViewById(R.id.header_button_right)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = bg.getNext();
                if(result > 0){
                    Drawable drawable = getResources().getDrawable(result);
                    layout.setBackgroundDrawable(drawable);
                }
            }
        });

    }

    class Bg{

        private int index;
        private int[] pngs;

        Bg(int[] pngs) {
            this.pngs = pngs;
        }

        public int getNext(){

            if(index>=pngs.length-1){
                return -1;
            }

            return pngs[++index];
        }

        public int getPrevis(){

            if(index<=0){
                return -1;
            }

            return pngs[--index];
        }
    }

}

