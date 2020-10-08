package com.example.test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

import com.naver.maps.map.MapFragment;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.util.FusedLocationSource;

import java.net.URI;

public class NaverMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final int ACCESS_LOCATION_PERMISSION_REQUEST_CODE = 100;
    private FusedLocationSource locationSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_navermap);

        MapFragment mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        class ApiExplorer {
//            public void main(String[] args) throws IOException {
//                StringBuilder urlBuilder = new StringBuilder("http://open.gyeongnam.go.kr/rest/서비스키"); /*URL*/
//                urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=서비스키"); /*Service Key*/
//                urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + URLEncoder.encode("서비스키", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
//                urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
//                urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
//                urlBuilder.append("&" + URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode("소원의항구", "UTF-8")); /*기관명*/
//                URL url = new URL(urlBuilder.toString());
//               HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                conn.setRequestMethod("GET");
//                conn.setRequestProperty("Content-type", "application/json");
//                System.out.println("Response code: " + conn.getResponseCode());
//                BufferedReader rd;
//                if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//                    rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                } else {
//                    rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//                }
//               StringBuilder sb = new StringBuilder();
//               String line;
//               while ((line = rd.readLine()) != null) {
//                   sb.append(line);
//               }
//                rd.close();
//                conn.disconnect();
 //              System.out.println(sb.toString());
 //          }
        }
//}

    @Override
    public void onMapReady(@NonNull com.naver.maps.map.NaverMap naverMap) {
        locationSource = new FusedLocationSource(this, ACCESS_LOCATION_PERMISSION_REQUEST_CODE);
        naverMap.setLocationSource(locationSource);
        UiSettings uiSettings = naverMap.getUiSettings();
        uiSettings.setLocationButtonEnabled(true);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case ACCESS_LOCATION_PERMISSION_REQUEST_CODE:
                locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults);
                return;
        }
    }
}