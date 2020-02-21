package com.example.kpmgtest;

import androidx.appcompat.app.AppCompatActivity;
import it.sauronsoftware.jave.InputFormatException;

import android.os.Bundle;
import android.view.View;

import com.microsoft.cognitiveservices.speech.*;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;

import java.util.concurrent.Future;

import static com.microsoft.cognitiveservices.speech.ResultReason.*;

public class AuzureSpeechTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naver_csrexample);


        try {
            // Replace below with your own subscription key
            String speechSubscriptionKey = "9aacaf994e8c42c5a6bbe5cb8c1b850f";

            // Replace with your own subscription key and region identifier from here: https://aka.ms/speech/sdkregion
            String serviceRegion = "https://koreacentral.api.cognitive.microsoft.com/";

            // Replace below with your own filename.
            String audioFileName = "/data/test.wav";

            int exitCode = 1;
            SpeechConfig config = SpeechConfig.fromSubscription(speechSubscriptionKey, serviceRegion);
            assert(config != null);

            AudioConfig audioInput = AudioConfig.fromWavFileInput(audioFileName);
            assert(audioInput != null);

            SpeechRecognizer reco = new SpeechRecognizer(config, audioInput);
            assert(reco != null);

            System.out.println("Recognizing first result...");

            Future<SpeechRecognitionResult> task = reco.recognizeOnceAsync();
            assert(task != null);

            SpeechRecognitionResult result = task.get();
            assert(result != null);

            switch (result.getReason()) {
                case RecognizedSpeech: {
                    System.out.println("We recognized: " + result.getText());
                    exitCode = 0;
                }
                break;
                case NoMatch:
                    System.out.println("NOMATCH: Speech could not be recognized.");
                    break;
                case Canceled: {
                    CancellationDetails cancellation = CancellationDetails.fromResult(result);
                    System.out.println("CANCELED: Reason=" + cancellation.getReason());

                    if (cancellation.getReason() == CancellationReason.Error) {
                        System.out.println("CANCELED: ErrorCode=" + cancellation.getErrorCode());
                        System.out.println("CANCELED: ErrorDetails=" + cancellation.getErrorDetails());
                        System.out.println("CANCELED: Did you update the subscription info?");
                    }
                }
                break;
            }

            reco.close();

            System.exit(exitCode);
        } catch (Exception ex) {
            System.out.println("Unexpected exception: " + ex.getMessage());

            assert(false);
            System.exit(1);
        }
    }

}
