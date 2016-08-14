package xiaodou.jd_autolayout.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import xiaodou.jd_autolayout.R;

/**
 * Created by DOU on 2016/8/14.
 */
public class TabView extends RelativeLayout {

    private TextView textView;

    public TabView(Context context) {
        this(context, null);
    }

    public TabView(Context context, AttributeSet attrs) {
        super(context, attrs);

        View.inflate(context, R.layout.fragment_view, this);
        textView = (TextView) findViewById(R.id.tv_text);
    }

    public void setText(String text){
        textView.setText(text);
    }

    public void setTextColor(int color){
        textView.setTextColor(color);
//        textView.setTextColor(0xF02B2B);

    }

}
