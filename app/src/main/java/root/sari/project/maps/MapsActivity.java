package root.sari.project.maps;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity {

   

    static final LatLng Kalibaru = new LatLng(-6.225826, 106.984660);
    private GoogleMap gMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        initMap();
    }

    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        gMap = mapFragment.getMap();
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Kalibaru, 15));
        addPolyLine();
    }

    private void addPolyLine() {
        Polyline polyline = gMap.addPolyline(new PolylineOptions()
                        .add(new LatLng(-6.227737, 106.987248),
                                new LatLng(-6.228956, 106.988954),
                                new LatLng(-6.229497, 106.989844),
                                new LatLng(-6.230476, 106.991435),
                                new LatLng(-6.230714, 106.991886),
                                new LatLng(-6.230829, 106.992265),
                                new LatLng(-6.230884, 106.992604),
                                new LatLng(-6.230815, 106.994197),
                                new LatLng(-6.230678, 106.996058),
                                new LatLng(-6.230655, 106.996747),
                                new LatLng(-6.230690, 106.997094),
                                new LatLng(-6.230851, 106.997606),
                                new LatLng(-6.231027, 106.997994),
                                new LatLng(-6.231435, 106.998558),
                                new LatLng(-6.231726, 106.998814),
                                new LatLng(-6.232979, 106.999667),
                                new LatLng(-6.232299, 107.000563),
                                new LatLng(-6.231995, 107.001097),
                                new LatLng(-6.230872, 107.002572),
                                new LatLng(-6.230861, 107.002631),
                                new LatLng(-6.231228, 107.003286),
                                new LatLng(-6.231546, 107.003808),
                                new LatLng(-6.231902, 107.004280),
                                new LatLng(-6.232149, 107.004515),
                                new LatLng(-6.233115, 107.005215),
                                new LatLng(-6.233338, 107.005438),
                                new LatLng(-6.233619, 107.005741),
                                new LatLng(-6.233773, 107.005857),
                                new LatLng(-6.234230, 107.006095),
                                new LatLng(-6.234573, 107.006314),
                                new LatLng(-6.234744, 107.006371),
                                new LatLng(-6.235316, 107.006455),
                                new LatLng(-6.235398, 107.006525),
                                new LatLng(-6.235477, 107.006756),
                                new LatLng(-6.235540, 107.006812),
                                new LatLng(-6.236001, 107.006962),
                                new LatLng(-6.236653, 107.006429)


                        ).width(10).color(Color.BLUE)
        );
    }
}

