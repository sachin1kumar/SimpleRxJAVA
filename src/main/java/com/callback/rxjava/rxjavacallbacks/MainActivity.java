package com.callback.rxjava.rxjavacallbacks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private Button mButton;
    private Observable<Integer> mObservable;
    private int count=0;
    private Observer<Integer> mObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);
        mButton = findViewById(R.id.button);
        mTextView.setText("Counter : "+String.valueOf(count));

        mObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer s) {
                mTextView.setText("Counter : "+String.valueOf(s));
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }


    public void increaseValue(View view) {
        count++;
        mObservable = Observable.just(count);
        mObservable.subscribe(mObserver);
    }
}
