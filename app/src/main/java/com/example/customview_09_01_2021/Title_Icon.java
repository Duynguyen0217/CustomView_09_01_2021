package com.example.customview_09_01_2021;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Title_Icon extends RelativeLayout {
    private String mTextTilte;
    private int mDrawableImage;


    private TextView mtextview;
    private ImageView mimageview;

    private OnListenerClick monListenerClick;

    public Title_Icon(Context context) {
        super(context);
    }

    public Title_Icon(Context context, AttributeSet attrs) {
        super(context, attrs);

        initview(context , attrs);
    }

    public Title_Icon(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initview(Context context, AttributeSet attributeSet){
        if(attributeSet != null && context != null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.layout_title_with_icon , this , true);

            TypedArray typedarray = context.obtainStyledAttributes(attributeSet , R.styleable.Title_Icon);
            mTextTilte = typedarray.getString(R.styleable.Title_Icon_text_title);
            mDrawableImage = typedarray.getResourceId(R.styleable.Title_Icon_drawable_icon , 0);
            typedarray.recycle();

            mapview(view);
            event();
        }

    }

    private void event() {
        mimageview.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                monListenerClick.onClickIcon();
            }
        });
    }

    private void mapview(View view) {
        mimageview = view.findViewById(R.id.ImageIcon);
        mtextview = view.findViewById(R.id.textviewTitle);

        if(mTextTilte.isEmpty()){
            mtextview.setText("");
        }
        else{
            mtextview.setText(mTextTilte);
        }
        mimageview.setImageResource(mDrawableImage);
    }

    public void setOnClickIcon(OnListenerClick onClickIcon){
        monListenerClick = onClickIcon;

    }



}
