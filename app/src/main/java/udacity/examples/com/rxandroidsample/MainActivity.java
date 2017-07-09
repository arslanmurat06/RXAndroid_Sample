package udacity.examples.com.rxandroidsample;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.reactivestreams.Subscription;

import java.util.Observer;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    TextView txtMetin;
    Button btnAbone;
  private Observable<String> observable;
   private io.reactivex.Observer<String> observer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMetin=(TextView) findViewById(R.id.txtMetin);
        btnAbone=(Button) findViewById(R.id.btnAbone);
        observable=Observable.just(" RxAndroid'den Merhaba");


        observer=new io.reactivex.Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {


            }

            @Override
            public void onNext(@NonNull String s) {

                txtMetin.setText(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };




    }

    public void aboneOl(View view) {

        observable.subscribe(observer);

    }
}
