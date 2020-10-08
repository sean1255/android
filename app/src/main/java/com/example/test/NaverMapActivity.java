package com.example.test;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.util.FusedLocationSource;

import java.net.URI;

public class NaverMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final int ACCESS_LOCATION_PERMISSION_REQUEST_CODE = 100;
    private FusedLocationSource locationSource;   // 현재 위치 표시

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navermap);

        MapFragment mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.map, mapFragment).commit();
        }

        mapFragment.getMapAsync(this);
    }

    @UiThread
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        // ...
        Marker marker1 = new Marker();
        marker1.setPosition(new LatLng(35.119836, 129.081171));
        marker1.setMap(naverMap);

        Marker marker2 = new Marker();
        marker2.setPosition(new LatLng(35.159516, 129.068027));
        marker2.setMap(naverMap);

        Marker marker3 = new Marker();
        marker3.setPosition(new LatLng(35.137958, 129.064754));
        marker3.setMap(naverMap);

        Marker marker4 = new Marker();
        marker4.setPosition(new LatLng(35.1198471,129.062608));
        marker4.setMap(naverMap);

        Marker marker5 = new Marker();
        marker5.setPosition(new LatLng(35.1172166,129.0521816));
        marker5.setMap(naverMap);

        Marker marker6 = new Marker();
        marker6.setPosition(new LatLng(35.154554,129.035846));
        marker6.setMap(naverMap);

        Marker marker7 = new Marker();
        marker7.setPosition(new LatLng(35.104241, 128.981231));
        marker7.setMap(naverMap);

        Marker marker8 = new Marker();
        marker8.setPosition(new LatLng(35.097060, 128.960205));
        marker8.setMap(naverMap);

        Marker marker9 = new Marker();
        marker9.setPosition(new LatLng(35.094554, 128.983375));
        marker9.setMap(naverMap);

        Marker marker10 = new Marker();
        marker10.setPosition(new LatLng(35.1524071,128.9666643));
        marker10.setMap(naverMap);

        Marker marker11 = new Marker();
        marker11.setPosition(new LatLng(35.194966, 129.080782));
        marker11.setMap(naverMap);

        Marker marker12 = new Marker();
        marker12.setPosition(new LatLng(35.192106, 129.082179));
        marker12.setMap(naverMap);

        Marker marker13 = new Marker();
        marker13.setPosition(new LatLng(35.212824, 129.081757));
        marker13.setMap(naverMap);

        Marker marker14 = new Marker();
        marker14.setPosition(new LatLng(35.203356, 129.070226));
        marker14.setMap(naverMap);

        Marker marker15 = new Marker();
        marker15.setPosition(new LatLng(35.200532, 129.056069));
        marker15.setMap(naverMap);

        Marker marker16 = new Marker();
        marker16.setPosition(new LatLng(35.218216, 129.037633));
        marker16.setMap(naverMap);

        Marker marker17 = new Marker();
        marker17.setPosition(new LatLng(35.195476, 129.008505));
        marker17.setMap(naverMap);



//        InfoWindow infoWindow = new InfoWindow();
//        infoWindow.setAdapter(new InfoWindow.DefaultTextAdapter(context) {
//            @NonNull
        //           @Override
        //           public CharSequence getText(@NonNull InfoWindow infoWindow1) {
//                return "복지관";
//            }
//        });

        locationSource = new FusedLocationSource(this, ACCESS_LOCATION_PERMISSION_REQUEST_CODE);
        naverMap.setLocationSource(locationSource);
        UiSettings uiSettings = naverMap.getUiSettings();  // 현재 위치 ui버튼
        uiSettings.setLocationButtonEnabled(true);

        naverMap.setLocationTrackingMode(LocationTrackingMode.Follow); // None, NoFollow, Follow, Face 가 있음
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {  // 위치 권한 허용 시도
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        switch (requestCode) {
            case ACCESS_LOCATION_PERMISSION_REQUEST_CODE:
                locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults);
                return;

//            if (locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults)) {
//                //if (!locationSource.isActivated()) {  // 권한 거부됨
            //    naverMap.setLocationTrackingMode(LocationTrackingMode);
//                return;
//            }
        }
    }
}




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
//       }
//}