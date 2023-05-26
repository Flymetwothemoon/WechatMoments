package View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.wechatmoments.R;

public class circleView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mColor = Color.BLACK;
    private Bitmap mBitmap;

    public circleView(Context context) {
        super(context);
        init();
    }

    public circleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        mBitmap = BitmapFactory.decodeResource(getResources(), array.getResourceId(R.styleable.CircleView_src, 0));
        array.recycle();
        init();
    }

    public circleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        mBitmap = BitmapFactory.decodeResource(getResources(), array.getResourceId(R.styleable.CircleView_src, 0));
        array.recycle();
        init();
    }

    public circleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint.setColor(mColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mBitmap != null && !mBitmap.isRecycled()) {
            int width = getWidth();
            int height = getHeight();
            int radius = Math.min(width, height) / 2;
            Path path = new Path();
            path.addCircle(width / 2f, height / 2f, radius, Path.Direction.CW);

            canvas.clipPath(path);
            canvas.drawBitmap(mBitmap, (width - mBitmap.getWidth()) / 2f, (height - mBitmap.getHeight()) / 2f, mPaint);
        }
    }
}