package root.sari.project.maps;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
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

public class MapsActivity extends AppCompatActivity implements LocationListener {
    String p1, p2, p3, p4;

    static final LatLng Kalibaru = new LatLng(-6.225826, 106.984660);
    private GoogleMap gMap;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Getting Google Play availability status
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());

        // Showing status
        if (status != ConnectionResult.SUCCESS) { // Google Play Services are not available

            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
            dialog.show();

        } else { // Google Play Services are available

            // Getting reference to the SupportMapFragment of activity_main.xml
            SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

            // Getting GoogleMap object from the fragment
            gMap = fm.getMap();

            // Enabling MyLocation Layer of Google Map
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            gMap.setMyLocationEnabled(true);

            // Getting LocationManager object from System Service LOCATION_SERVICE
            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

            // Creating a criteria object to retrieve provider
            Criteria criteria = new Criteria();

            // Getting the name of the best provider
            String provider = locationManager.getBestProvider(criteria, true);

            // Getting Current Location
            Location location = locationManager.getLastKnownLocation(provider);

            if(location!=null){
                onLocationChanged(location);
            }
            locationManager.requestLocationUpdates(provider, 20000, 0, this);
        }



        //initMap();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Kalibaru, 15));

        addPolyLine1();
        addPolyLine2();
        addPolyLine3();
        addPolyLine4();
        gMap.setOnPolylineClickListener(new GoogleMap.OnPolylineClickListener() {
            @Override
            public void onPolylineClick(Polyline polyline) {


                if(polyline.getId().equals(p1)){

                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MapsActivity.this);
                    alertDialog.setTitle("Ini isi polyline1");


                    alertDialog.setMessage("Isi Sendiri");


                    alertDialog.setPositiveButton("Tutup", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });


                    alertDialog.show();


                }

                else if(polyline.getId().equals(p2)){

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MapsActivity.this);
                    alertDialog.setTitle("Ini isi polyline2");


                    alertDialog.setMessage("Isi Sendiri");


                    alertDialog.setPositiveButton("Tutup", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });



                    alertDialog.show();


                }


                else if(polyline.getId().equals(p3)){

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MapsActivity.this);
                    alertDialog.setTitle("Ini isi polyline3");


                    alertDialog.setMessage("Isi Sendiri");


                    alertDialog.setPositiveButton("Tutup", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });



                    alertDialog.show();


                }


                else if(polyline.getId().equals(p4)){

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MapsActivity.this);
                    alertDialog.setTitle("Ini isi polyline4");


                    alertDialog.setMessage("Isi Sendiri");


                    alertDialog.setPositiveButton("Tutup", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });



                    alertDialog.show();


                }






            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch(item.getItemId())
        {
            case R.id.satu:
                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                gMap.clear();
                addPolyLine1();

                return true;

            case R.id.dua:
                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                gMap.clear();
                addPolyLine2();

                return true;

            case R.id.tiga:
                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                gMap.clear();
                addPolyLine3();

                return true;

            case R.id.empat:
                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                gMap.clear();
                addPolyLine4();
                return true;

            case R.id.lima:
                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                gMap.clear();
                addPolyLine1();
                addPolyLine2();
                addPolyLine3();
                addPolyLine4();
                return true;




        }
        return super.onOptionsItemSelected(item);

    }


    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        gMap = mapFragment.getMap();
        //gMap.setMyLocationEnabled(true);
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Kalibaru, 15));
        //gMap.setOnPolylineClickListener();
        addPolyLine1();
        addPolyLine2();
        addPolyLine3();
        addPolyLine4();
        gMap.setOnPolylineClickListener(new GoogleMap.OnPolylineClickListener() {
            @Override
            public void onPolylineClick(Polyline polyline) {


            if(polyline.getId().equals(p1)){

                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MapsActivity.this);
                alertDialog.setTitle("Ini isi polyline1");


                alertDialog.setMessage("Isi Sendiri");


                alertDialog.setPositiveButton("Tutup", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    finish();
                    }
                });


                alertDialog.show();


            }

            else if(polyline.getId().equals(p2)){

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MapsActivity.this);
                alertDialog.setTitle("Ini isi polyline2");


                alertDialog.setMessage("Isi Sendiri");


                alertDialog.setPositiveButton("Tutup", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });



                alertDialog.show();


            }


            else if(polyline.getId().equals(p3)){

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MapsActivity.this);
                alertDialog.setTitle("Ini isi polyline3");


                alertDialog.setMessage("Isi Sendiri");


                alertDialog.setPositiveButton("Tutup", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });



                alertDialog.show();


            }


            else if(polyline.getId().equals(p4)){

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MapsActivity.this);
                alertDialog.setTitle("Ini isi polyline4");


                alertDialog.setMessage("Isi Sendiri");


                alertDialog.setPositiveButton("Tutup", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });



                alertDialog.show();


            }






        }

        });
    }

    private void addPolyLine1() {
        Polyline polyline1 = gMap.addPolyline(new PolylineOptions()
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


                ).width(10).color(Color.BLUE));
        polyline1.setClickable(true);
        p1=polyline1.getId();

    }

    private void addPolyLine2() {
        Polyline polyline2 = gMap.addPolyline(new PolylineOptions()
                        .add(new LatLng(-6.342514, 106.922713),
                                new LatLng(-6.340256, 106.922943),
                                new LatLng(-6.338654, 106.923115),
                                new LatLng(-6.335687, 106.923498),
                                new LatLng(-6.334308, 106.923566),
                                new LatLng(-6.333619, 106.923658),
                                new LatLng(-6.332963, 106.923755),
                                new LatLng(-6.331414, 106.924012),
                                new LatLng(-6.330974, 106.924090),
                                new LatLng(-6.330241, 106.924152),
                                new LatLng(-6.329581, 106.924122),
                                new LatLng(-6.328664, 106.924168),
                                new LatLng(-6.324975, 106.924058),
                                new LatLng(-6.323943, 106.923900),
                                new LatLng(-6.323095, 106.923838),
                                new LatLng(-6.322560, 106.923799),
                                new LatLng(-6.320931, 106.923802),
                                new LatLng(-6.320089, 106.923845),
                                new LatLng(-6.319614, 106.923832),
                                new LatLng(-6.318311, 106.923859),
                                new LatLng(-6.316914, 106.923939),
                                new LatLng(-6.316578, 106.923998),
                                new LatLng(-6.315912, 106.924207),
                                new LatLng(-6.315038, 106.924483),
                                new LatLng(-6.313878, 106.924781),
                                new LatLng(-6.311823, 106.924628),
                                new LatLng(-6.310915, 106.924445),
                                new LatLng(-6.310902, 106.924330),
                                new LatLng(-6.310833, 106.924228),
                                new LatLng(-6.310737, 106.924181),
                                new LatLng(-6.310646, 106.924180),
                                new LatLng(-6.310503, 106.924275),
                                new LatLng(-6.310454, 106.924370),
                                new LatLng(-6.309436, 106.924268),
                                new LatLng(-6.309108, 106.924198),
                                new LatLng(-6.308482, 106.924167),
                                new LatLng(-6.307395, 106.923902),
                                new LatLng(-6.305665, 106.923661),
                                new LatLng(-6.305567, 106.923639),
                                new LatLng(-6.304661, 106.923581),
                                new LatLng(-6.304473, 106.923574),
                                new LatLng(-6.303039, 106.923649),
                                new LatLng(-6.301647, 106.923820),
                                new LatLng(-6.300725, 106.923945),
                                new LatLng(-6.299875, 106.924034),
                                new LatLng(-6.299684, 106.923988),
                                new LatLng(-6.299516, 106.923938),
                                new LatLng(-6.298771, 106.923629),
                                new LatLng(-6.298620, 106.923541),
                                new LatLng(-6.298342, 106.923367),
                                new LatLng(-6.298153, 106.923199),
                                new LatLng(-6.297457, 106.922564),
                                new LatLng(-6.296773, 106.921867),
                                new LatLng(-6.296450, 106.921478),
                                new LatLng(-6.295957, 106.920762),
                                new LatLng(-6.295744, 106.920540),
                                new LatLng(-6.295620, 106.920435),
                                new LatLng(-6.295458, 106.920353),
                                new LatLng(-6.294841, 106.920146),
                                new LatLng(-6.294500, 106.919975),
                                new LatLng(-6.293279, 106.919014),
                                new LatLng(-6.290110, 106.916513),
                                new LatLng(-6.288681, 106.915391),
                                new LatLng(-6.286266, 106.913402),
                                new LatLng(-6.285802, 106.913006),
                                new LatLng(-6.285274, 106.912622),
                                new LatLng(-6.285522, 106.911927),
                                new LatLng(-6.285612, 106.911605),
                                new LatLng(-6.285603, 106.911463),
                                new LatLng(-6.285534, 106.911323),
                                new LatLng(-6.285079, 106.910843),
                                new LatLng(-6.284725, 106.910320),
                                new LatLng(-6.284280, 106.909814),
                                new LatLng(-6.284280, 106.909814),
                                new LatLng(-6.284456, 106.907934),
                                new LatLng(-6.284733, 106.905963),
                                new LatLng(-6.284857, 106.904427),
                                new LatLng(-6.285035, 106.902767),
                                new LatLng(-6.285259, 106.900914),
                                new LatLng(-6.285305, 106.900433),
                                new LatLng(-6.285359, 106.900115),
                                new LatLng(-6.285417, 106.899945),
                                new LatLng(-6.285522, 106.899786),
                                new LatLng(-6.285687, 106.899636),
                                new LatLng(-6.286062, 106.899317),
                                new LatLng(-6.287574, 106.898141),
                                new LatLng(-6.288471, 106.897504),
                                new LatLng(-6.288583, 106.897410),
                                new LatLng(-6.288828, 106.897160),
                                new LatLng(-6.289180, 106.896686),
                                new LatLng(-6.289379, 106.896367),
                                new LatLng(-6.289566, 106.895957),
                                new LatLng(-6.289632, 106.895686),
                                new LatLng(-6.289857, 106.893356),
                                new LatLng(-6.290179, 106.890634),
                                new LatLng(-6.290269, 106.890121),
                                new LatLng(-6.290462, 106.888824),
                                new LatLng(-6.291182, 106.888524),
                                new LatLng(-6.290930, 106.888371),
                                new LatLng(-6.290749, 106.888216),
                                new LatLng(-6.290601, 106.888045),
                                new LatLng(-6.290974, 106.885996),
                                new LatLng(-6.291066, 106.885256),
                                new LatLng(-6.291055, 106.884939),
                                new LatLng(-6.290970, 106.884614),
                                new LatLng(-6.290627, 106.883543),
                                new LatLng(-6.290632, 106.883465),
                                new LatLng(-6.290417, 106.882510),
                                new LatLng(-6.290303, 106.881893),
                                new LatLng(-6.290219, 106.881157),
                                new LatLng(-6.290123, 106.880859),
                                new LatLng(-6.290036, 106.880510),
                                new LatLng(-6.289931, 106.880485),
                                new LatLng(-6.289622, 106.880345),
                                new LatLng(-6.289378, 106.880193),
                                new LatLng(-6.288913, 106.880016),
                                new LatLng(-6.288805, 106.879934),
                                new LatLng(-6.288711, 106.879776),
                                new LatLng(-6.288706, 106.879587),
                                new LatLng(-6.288727, 106.879507),
                                new LatLng(-6.289138, 106.878480),
                                new LatLng(-6.289395, 106.877840),
                                new LatLng(-6.289427, 106.877650),
                                new LatLng(-6.289396, 106.877464),
                                new LatLng(-6.289342, 106.877344),
                                new LatLng(-6.288225, 106.874857),
                                new LatLng(-6.288052, 106.874486),
                                new LatLng(-6.287916, 106.874090),
                                new LatLng(-6.287867, 106.873890),
                                new LatLng(-6.287622, 106.872620),
                                new LatLng(-6.287572, 106.872425),
                                new LatLng(-6.287180, 106.871214),
                                new LatLng(-6.287088, 106.870865),
                                new LatLng(-6.287511, 106.870819),
                                new LatLng(-6.287804, 106.870810),
                                new LatLng(-6.288102, 106.870827),
                                new LatLng(-6.288426, 106.870878),
                                new LatLng(-6.288795, 106.870959),
                                new LatLng(-6.289067, 106.871035),
                                new LatLng(-6.289502, 106.871182),
                                new LatLng(-6.290108, 106.871363),
                                new LatLng(-6.290810, 106.871580),
                                new LatLng(-6.291855, 106.871891),
                                new LatLng(-6.292825, 106.872128),
                                new LatLng(-6.293080, 106.872170),
                                new LatLng(-6.293409, 106.872184),
                                new LatLng(-6.293700, 106.872173),
                                new LatLng(-6.294956, 106.871954),
                                new LatLng(-6.295932, 106.871778),
                                new LatLng(-6.296936, 106.871435),
                                new LatLng(-6.297801, 106.871062),
                                new LatLng(-6.298338, 106.870850),
                                new LatLng(-6.298850, 106.870583),
                                new LatLng(-6.299200, 106.870335),
                                new LatLng(-6.300600, 106.869200),
                                new LatLng(-6.301314, 106.868614),
                                new LatLng(-6.301378, 106.868555),
                                new LatLng(-6.301762, 106.868221),
                                new LatLng(-6.301881, 106.868134),
                                new LatLng(-6.302693, 106.867502)

                        ).width(10).color(Color.GREEN)
        );
        polyline2.setClickable(true);
        p2=polyline2.getId();

    }

    private void addPolyLine3() {
        Polyline polyline3 = gMap.addPolyline(new PolylineOptions()
                        .add(new LatLng(-6.342514, 106.922713),
                                new LatLng(-6.340256, 106.922943),
                                new LatLng(-6.338654, 106.923115),
                                new LatLng(-6.335687, 106.923498),
                                new LatLng(-6.334308, 106.923566),
                                new LatLng(-6.333619, 106.923658),
                                new LatLng(-6.332963, 106.923755),
                                new LatLng(-6.331414, 106.924012),
                                new LatLng(-6.330974, 106.924090),
                                new LatLng(-6.330241, 106.924152),
                                new LatLng(-6.329581, 106.924122),
                                new LatLng(-6.328664, 106.924168),
                                new LatLng(-6.324975, 106.924058),
                                new LatLng(-6.323943, 106.923900),
                                new LatLng(-6.323095, 106.923838),
                                new LatLng(-6.322560, 106.923799),
                                new LatLng(-6.320931, 106.923802),
                                new LatLng(-6.320089, 106.923845),
                                new LatLng(-6.319614, 106.923832),
                                new LatLng(-6.318311, 106.923859),
                                new LatLng(-6.316914, 106.923939),
                                new LatLng(-6.316578, 106.923998),
                                new LatLng(-6.315912, 106.924207),
                                new LatLng(-6.315038, 106.924483),
                                new LatLng(-6.313878, 106.924781),
                                new LatLng(-6.311823, 106.924628),
                                new LatLng(-6.310915, 106.924445),
                                new LatLng(-6.310902, 106.924330),
                                new LatLng(-6.310833, 106.924228),
                                new LatLng(-6.310737, 106.924181),
                                new LatLng(-6.310646, 106.924180),
                                new LatLng(-6.310503, 106.924275),
                                new LatLng(-6.310454, 106.924370),
                                new LatLng(-6.309436, 106.924268),
                                new LatLng(-6.309108, 106.924198),
                                new LatLng(-6.308482, 106.924167),
                                new LatLng(-6.307395, 106.923902),
                                new LatLng(-6.305665, 106.923661),
                                new LatLng(-6.305567, 106.923639),
                                new LatLng(-6.304661, 106.923581),
                                new LatLng(-6.304473, 106.923574),
                                new LatLng(-6.303039, 106.923649),
                                new LatLng(-6.301647, 106.923820),
                                new LatLng(-6.300725, 106.923945),
                                new LatLng(-6.299875, 106.924034),
                                new LatLng(-6.299684, 106.923988),
                                new LatLng(-6.299516, 106.923938),
                                new LatLng(-6.298771, 106.923629),
                                new LatLng(-6.298620, 106.923541),
                                new LatLng(-6.298342, 106.923367),
                                new LatLng(-6.298153, 106.923199),
                                new LatLng(-6.297457, 106.922564),
                                new LatLng(-6.296773, 106.921867),
                                new LatLng(-6.296450, 106.921478),
                                new LatLng(-6.295957, 106.920762),
                                new LatLng(-6.295744, 106.920540),
                                new LatLng(-6.295620, 106.920435),
                                new LatLng(-6.295458, 106.920353),
                                new LatLng(-6.294841, 106.920146),
                                new LatLng(-6.294500, 106.919975),
                                new LatLng(-6.293279, 106.919014),
                                new LatLng(-6.290110, 106.916513),
                                new LatLng(-6.288681, 106.915391),
                                new LatLng(-6.286266, 106.913402),
                                new LatLng(-6.285802, 106.913006),
                                new LatLng(-6.285274, 106.912622),
                                new LatLng(-6.285522, 106.911927),
                                new LatLng(-6.285612, 106.911605),
                                new LatLng(-6.285603, 106.911463),
                                new LatLng(-6.285534, 106.911323),
                                new LatLng(-6.285079, 106.910843),
                                new LatLng(-6.284725, 106.910320),
                                new LatLng(-6.284280, 106.909814),
                                new LatLng(-6.284280, 106.909814),
                                new LatLng(-6.284456, 106.907934),
                                new LatLng(-6.284733, 106.905963),
                                new LatLng(-6.284857, 106.904427),
                                new LatLng(-6.285035, 106.902767),
                                new LatLng(-6.285259, 106.900914),
                                new LatLng(-6.285305, 106.900433),
                                new LatLng(-6.285359, 106.900115),
                                new LatLng(-6.285417, 106.899945),
                                new LatLng(-6.285522, 106.899786),
                                new LatLng(-6.285687, 106.899636),
                                new LatLng(-6.286062, 106.899317),
                                new LatLng(-6.287574, 106.898141),
                                new LatLng(-6.288471, 106.897504),
                                new LatLng(-6.288583, 106.897410),
                                new LatLng(-6.288828, 106.897160),
                                new LatLng(-6.289180, 106.896686),
                                new LatLng(-6.289379, 106.896367),
                                new LatLng(-6.289566, 106.895957),
                                new LatLng(-6.289632, 106.895686),
                                new LatLng(-6.289857, 106.893356),
                                new LatLng(-6.290179, 106.890634),
                                new LatLng(-6.290269, 106.890121),
                                new LatLng(-6.290462, 106.888824),
                                new LatLng(-6.291182, 106.888524),
                                new LatLng(-6.290930, 106.888371),
                                new LatLng(-6.290749, 106.888216),
                                new LatLng(-6.290601, 106.888045),
                                new LatLng(-6.290974, 106.885996),
                                new LatLng(-6.291066, 106.885256),
                                new LatLng(-6.291055, 106.884939),
                                new LatLng(-6.290970, 106.884614),
                                new LatLng(-6.290627, 106.883543),
                                new LatLng(-6.290632, 106.883465),
                                new LatLng(-6.290417, 106.882510),
                                new LatLng(-6.290303, 106.881893),
                                new LatLng(-6.290219, 106.881157),
                                new LatLng(-6.290123, 106.880859),
                                new LatLng(-6.290036, 106.880510),
                                new LatLng(-6.289931, 106.880485),
                                new LatLng(-6.289622, 106.880345),
                                new LatLng(-6.289378, 106.880193),
                                new LatLng(-6.288913, 106.880016),
                                new LatLng(-6.288805, 106.879934),
                                new LatLng(-6.288711, 106.879776),
                                new LatLng(-6.288706, 106.879587),
                                new LatLng(-6.288727, 106.879507),
                                new LatLng(-6.289138, 106.878480),
                                new LatLng(-6.289395, 106.877840),
                                new LatLng(-6.289427, 106.877650),
                                new LatLng(-6.289396, 106.877464),
                                new LatLng(-6.289342, 106.877344),
                                new LatLng(-6.288225, 106.874857),
                                new LatLng(-6.288052, 106.874486),
                                new LatLng(-6.287916, 106.874090),
                                new LatLng(-6.287867, 106.873890),
                                new LatLng(-6.287622, 106.872620),
                                new LatLng(-6.287572, 106.872425),
                                new LatLng(-6.287180, 106.871214),
                                new LatLng(-6.287088, 106.870865),
                                new LatLng(-6.287511, 106.870819),
                                new LatLng(-6.287804, 106.870810),
                                new LatLng(-6.288102, 106.870827),
                                new LatLng(-6.288426, 106.870878),
                                new LatLng(-6.288795, 106.870959),
                                new LatLng(-6.289067, 106.871035),
                                new LatLng(-6.289502, 106.871182),
                                new LatLng(-6.290108, 106.871363),
                                new LatLng(-6.290810, 106.871580),
                                new LatLng(-6.291855, 106.871891),
                                new LatLng(-6.292825, 106.872128),
                                new LatLng(-6.293080, 106.872170),
                                new LatLng(-6.293409, 106.872184),
                                new LatLng(-6.293700, 106.872173),
                                new LatLng(-6.294956, 106.871954),
                                new LatLng(-6.295932, 106.871778),
                                new LatLng(-6.296936, 106.871435),
                                new LatLng(-6.297801, 106.871062),
                                new LatLng(-6.298338, 106.870850),
                                new LatLng(-6.298850, 106.870583),
                                new LatLng(-6.299200, 106.870335),
                                new LatLng(-6.300600, 106.869200),
                                new LatLng(-6.301314, 106.868614),
                                new LatLng(-6.301378, 106.868555),
                                new LatLng(-6.301762, 106.868221),
                                new LatLng(-6.301881, 106.868134),
                                new LatLng(-6.302693, 106.867502)

                        ).width(10).color(Color.RED)
        );
        polyline3.setClickable(true);
        p3=polyline3.getId();
    }

    private void addPolyLine4() {
        Polyline polyline4 = gMap.addPolyline(new PolylineOptions()
                        .add(new LatLng(-6.339717, 106.944823),
                                new LatLng(-6.340262, 106.944771),
                                new LatLng(-6.340428, 106.944696),
                                new LatLng(-6.341017, 106.944511),
                                new LatLng(-6.342353, 106.944141),
                                new LatLng(-6.342395, 106.944160),
                                new LatLng(-6.345038, 106.943371),
                                new LatLng(-6.345174, 106.943317),
                                new LatLng(-6.345999, 106.943083),
                                new LatLng(-6.346300, 106.942942),
                                new LatLng(-6.346337, 106.942891),
                                new LatLng(-6.346911, 106.942706),
                                new LatLng(-6.347076, 106.942640),
                                new LatLng(-6.347392, 106.942496),
                                new LatLng(-6.347645, 106.942344),
                                new LatLng(-6.347888, 106.942223),
                                new LatLng(-6.348276, 106.942060),
                                new LatLng(-6.348811, 106.941876),
                                new LatLng(-6.348969, 106.941798),
                                new LatLng(-6.349151, 106.941642),
                                new LatLng(-6.349299, 106.941486),
                                new LatLng(-6.349395, 106.941411),
                                new LatLng(-6.349490, 106.941343),
                                new LatLng(-6.349609, 106.941283),
                                new LatLng(-6.349943, 106.941155),
                                new LatLng(-6.350114, 106.941039),
                                new LatLng(-6.350516, 106.940691),
                                new LatLng(-6.351051, 106.940055),
                                new LatLng(-6.351144, 106.939811),
                                new LatLng(-6.351203, 106.939147),
                                new LatLng(-6.351239, 106.938955),
                                new LatLng(-6.351290, 106.938873),
                                new LatLng(-6.351357, 106.938827),
                                new LatLng(-6.351471, 106.938782),
                                new LatLng(-6.351944, 106.938658),
                                new LatLng(-6.352232, 106.938560),
                                new LatLng(-6.352415, 106.938437),
                                new LatLng(-6.352470, 106.938256),
                                new LatLng(-6.352569, 106.937334),
                                new LatLng(-6.352619, 106.937003),
                                new LatLng(-6.352666, 106.936811),
                                new LatLng(-6.352470, 106.936573),
                                new LatLng(-6.352193, 106.936450),
                                new LatLng(-6.352019, 106.936279),
                                new LatLng(-6.351572, 106.935709),
                                new LatLng(-6.351362, 106.935476),
                                new LatLng(-6.350983, 106.935170),
                                new LatLng(-6.350864, 106.935143),
                                new LatLng(-6.350388, 106.935127),
                                new LatLng(-6.350275, 106.935093),
                                new LatLng(-6.349727, 106.934796),
                                new LatLng(-6.349098, 106.934458),
                                new LatLng(-6.348887, 106.934418),
                                new LatLng(-6.348146, 106.934504),
                                new LatLng(-6.348092, 106.934477),
                                new LatLng(-6.348006, 106.934389),
                                new LatLng(-6.347881, 106.934298),
                                new LatLng(-6.347371, 106.934036),
                                new LatLng(-6.346928, 106.933944),
                                new LatLng(-6.346824, 106.933884),
                                new LatLng(-6.346731, 106.933796),
                                new LatLng(-6.345766, 106.932155),
                                new LatLng(-6.345574, 106.931932),
                                new LatLng(-6.345141, 106.931533),
                                new LatLng(-6.345079, 106.931395),
                                new LatLng(-6.344979, 106.931043),
                                new LatLng(-6.344894, 106.930889),
                                new LatLng(-6.344661, 106.930585),
                                new LatLng(-6.344318, 106.930170),
                                new LatLng(-6.344066, 106.929973),
                                new LatLng(-6.343730, 106.929764),
                                new LatLng(-6.342991, 106.929432),
                                new LatLng(-6.342943, 106.929387),
                                new LatLng(-6.342735, 106.929004),
                                new LatLng(-6.342626, 106.928932),
                                new LatLng(-6.342507, 106.928723),
                                new LatLng(-6.342150, 106.929008),
                                new LatLng(-6.342036, 106.929150),
                                new LatLng(-6.341952, 106.929237),
                                new LatLng(-6.341693, 106.929414),
                                new LatLng(-6.341206, 106.929664),
                                new LatLng(-6.340941, 106.929845),
                                new LatLng(-6.339919, 106.930691),
                                new LatLng(-6.339634, 106.930921),
                                new LatLng(-6.339494, 106.931064),
                                new LatLng(-6.338666, 106.931995),
                                new LatLng(-6.338132, 106.932495),
                                new LatLng(-6.337833, 106.932644),
                                new LatLng(-6.336615, 106.933282),
                                new LatLng(-6.336164, 106.933449),
                                new LatLng(-6.334646, 106.933893),
                                new LatLng(-6.333692, 106.934075),
                                new LatLng(-6.332992, 106.934252),
                                new LatLng(-6.332613, 106.934375),
                                new LatLng(-6.332599, 106.934377),
                                new LatLng(-6.331864, 106.934673),
                                new LatLng(-6.329446, 106.935663),
                                new LatLng(-6.327780, 106.936326),
                                new LatLng(-6.327398, 106.936457),
                                new LatLng(-6.327198, 106.936562),
                                new LatLng(-6.326259, 106.936930),
                                new LatLng(-6.325590, 106.937244),
                                new LatLng(-6.325058, 106.937532),
                                new LatLng(-6.324867, 106.937702),
                                new LatLng(-6.324772, 106.937756),
                                new LatLng(-6.324513, 106.937782),
                                new LatLng(-6.323759, 106.937613),
                                new LatLng(-6.322627, 106.937481),
                                new LatLng(-6.321285, 106.937245),
                                new LatLng(-6.320640, 106.936912),
                                new LatLng(-6.320178, 106.936697),
                                new LatLng(-6.319880, 106.936611),
                                new LatLng(-6.319169, 106.936465),
                                new LatLng(-6.318209, 106.936323),
                                new LatLng(-6.317630, 106.936396),
                                new LatLng(-6.316829, 106.936430),
                                new LatLng(-6.315957, 106.936642),
                                new LatLng(-6.315679, 106.936671),
                                new LatLng(-6.315402, 106.936756),
                                new LatLng(-6.315287, 106.936804),
                                new LatLng(-6.314999, 106.937009),
                                new LatLng(-6.314780, 106.937081),
                                new LatLng(-6.314495, 106.937138),
                                new LatLng(-6.314238, 106.937171),
                                new LatLng(-6.314238, 106.937171),
                                new LatLng(-6.312916, 106.937189),
                                new LatLng(-6.312635, 106.937163),
                                new LatLng(-6.311998, 106.936995),
                                new LatLng(-6.310994, 106.936870),
                                new LatLng(-6.310741, 106.936778),
                                new LatLng(-6.310446, 106.936602),
                                new LatLng(-6.310301, 106.936552),
                                new LatLng(-6.309352, 106.936395),
                                new LatLng(-6.309182, 106.936388),
                                new LatLng(-6.308337, 106.936444),
                                new LatLng(-6.307567, 106.936677),
                                new LatLng(-6.307472, 106.936593),
                                new LatLng(-6.307366, 106.936576),
                                new LatLng(-6.307331, 106.936583),
                                new LatLng(-6.307363, 106.936484),
                                new LatLng(-6.307625, 106.935933),
                                new LatLng(-6.307751, 106.935512),
                                new LatLng(-6.307650, 106.935429),
                                new LatLng(-6.307336, 106.935210),
                                new LatLng(-6.306985, 106.934942),
                                new LatLng(-6.306614, 106.934625),
                                new LatLng(-6.306539, 106.934524),
                                new LatLng(-6.306339, 106.934332),
                                new LatLng(-6.306084, 106.934190),
                                new LatLng(-6.305968, 106.934150),
                                new LatLng(-6.305834, 106.934128),
                                new LatLng(-6.305726, 106.934039),
                                new LatLng(-6.305526, 106.933633),
                                new LatLng(-6.305374, 106.933412),
                                new LatLng(-6.305222, 106.933235),
                                new LatLng(-6.304619, 106.932640),
                                new LatLng(-6.304458, 106.932389),
                                new LatLng(-6.304351, 106.932210),
                                new LatLng(-6.304086, 106.931971),
                                new LatLng(-6.303986, 106.931941),
                                new LatLng(-6.303662, 106.932008),
                                new LatLng(-6.303593, 106.931989),
                                new LatLng(-6.303464, 106.931910),
                                new LatLng(-6.303358, 106.931808),
                                new LatLng(-6.303228, 106.931630),
                                new LatLng(-6.303228, 106.931630),
                                new LatLng(-6.302876, 106.931313),
                                new LatLng(-6.302632, 106.931263),
                                new LatLng(-6.302544, 106.931226),
                                new LatLng(-6.302378, 106.931099),
                                new LatLng(-6.302197, 106.930929),
                                new LatLng(-6.301998, 106.930794),
                                new LatLng(-6.301749, 106.930642),
                                new LatLng(-6.301674, 106.930560),
                                new LatLng(-6.301344, 106.930246),
                                new LatLng(-6.300747, 106.929852),
                                new LatLng(-6.300472, 106.929730),
                                new LatLng(-6.300229, 106.929552),
                                new LatLng(-6.299684, 106.929001),
                                new LatLng(-6.299129, 106.928608),
                                new LatLng(-6.299045, 106.928473),
                                new LatLng(-6.298952, 106.928182),
                                new LatLng(-6.298597, 106.926814),
                                new LatLng(-6.298561, 106.926624),
                                new LatLng(-6.298269, 106.925750),
                                new LatLng(-6.298193, 106.925389),
                                new LatLng(-6.298049, 106.924932),
                                new LatLng(-6.297994, 106.924804),
                                new LatLng(-6.297926, 106.924675),
                                new LatLng(-6.297872, 106.924483),
                                new LatLng(-6.297870, 106.923647),
                                new LatLng(-6.297839, 106.923390),
                                new LatLng(-6.297766, 106.923244),
                                new LatLng(-6.297682, 106.923172),
                                new LatLng(-6.297467, 106.923064),
                                new LatLng(-6.297034, 106.922910),
                                new LatLng(-6.296723, 106.922643),
                                new LatLng(-6.296598, 106.922523),
                                new LatLng(-6.296415, 106.922224),
                                new LatLng(-6.296393, 106.922003),
                                new LatLng(-6.296395, 106.921804),
                                new LatLng(-6.296461, 106.921511),
                                new LatLng(-6.295957, 106.920762),
                                new LatLng(-6.295744, 106.920540),
                                new LatLng(-6.295620, 106.920435),
                                new LatLng(-6.295458, 106.920353),
                                new LatLng(-6.294841, 106.920146),
                                new LatLng(-6.294500, 106.919975),
                                new LatLng(-6.293279, 106.919014),
                                new LatLng(-6.290110, 106.916513),
                                new LatLng(-6.288681, 106.915391),
                                new LatLng(-6.286266, 106.913402),
                                new LatLng(-6.285802, 106.913006),
                                new LatLng(-6.285274, 106.912622),
                                new LatLng(-6.285522, 106.911927),
                                new LatLng(-6.285612, 106.911605),
                                new LatLng(-6.285603, 106.911463),
                                new LatLng(-6.285534, 106.911323),
                                new LatLng(-6.285079, 106.910843),
                                new LatLng(-6.284725, 106.910320),
                                new LatLng(-6.284280, 106.909814),
                                new LatLng(-6.284280, 106.909814),
                                new LatLng(-6.284456, 106.907934),
                                new LatLng(-6.284733, 106.905963),
                                new LatLng(-6.284857, 106.904427),
                                new LatLng(-6.285035, 106.902767),
                                new LatLng(-6.285259, 106.900914),
                                new LatLng(-6.285305, 106.900433),
                                new LatLng(-6.285359, 106.900115),
                                new LatLng(-6.285417, 106.899945),
                                new LatLng(-6.285522, 106.899786),
                                new LatLng(-6.285687, 106.899636),
                                new LatLng(-6.286062, 106.899317),
                                new LatLng(-6.287574, 106.898141),
                                new LatLng(-6.288471, 106.897504),
                                new LatLng(-6.288583, 106.897410),
                                new LatLng(-6.288828, 106.897160),
                                new LatLng(-6.289180, 106.896686),
                                new LatLng(-6.289379, 106.896367),
                                new LatLng(-6.289566, 106.895957),
                                new LatLng(-6.289632, 106.895686),
                                new LatLng(-6.289857, 106.893356),
                                new LatLng(-6.290179, 106.890634),
                                new LatLng(-6.290269, 106.890121),
                                new LatLng(-6.290462, 106.888824),
                                new LatLng(-6.291182, 106.888524),
                                new LatLng(-6.290930, 106.888371),
                                new LatLng(-6.290749, 106.888216),
                                new LatLng(-6.290601, 106.888045),
                                new LatLng(-6.290974, 106.885996),
                                new LatLng(-6.291066, 106.885256),
                                new LatLng(-6.291055, 106.884939),
                                new LatLng(-6.290970, 106.884614),
                                new LatLng(-6.290627, 106.883543),
                                new LatLng(-6.290632, 106.883465),
                                new LatLng(-6.290417, 106.882510),
                                new LatLng(-6.290303, 106.881893),
                                new LatLng(-6.290219, 106.881157),
                                new LatLng(-6.290123, 106.880859),
                                new LatLng(-6.290036, 106.880510),
                                new LatLng(-6.289931, 106.880485),
                                new LatLng(-6.289622, 106.880345),
                                new LatLng(-6.289378, 106.880193),
                                new LatLng(-6.288913, 106.880016),
                                new LatLng(-6.288805, 106.879934),
                                new LatLng(-6.288711, 106.879776),
                                new LatLng(-6.288706, 106.879587),
                                new LatLng(-6.288727, 106.879507),
                                new LatLng(-6.289138, 106.878480),
                                new LatLng(-6.289395, 106.877840),
                                new LatLng(-6.289427, 106.877650),
                                new LatLng(-6.289396, 106.877464),
                                new LatLng(-6.289342, 106.877344),
                                new LatLng(-6.288225, 106.874857),
                                new LatLng(-6.288052, 106.874486),
                                new LatLng(-6.287916, 106.874090),
                                new LatLng(-6.287867, 106.873890),
                                new LatLng(-6.287622, 106.872620),
                                new LatLng(-6.287572, 106.872425),
                                new LatLng(-6.287180, 106.871214),
                                new LatLng(-6.287088, 106.870865),
                                new LatLng(-6.287511, 106.870819),
                                new LatLng(-6.287804, 106.870810),
                                new LatLng(-6.288102, 106.870827),
                                new LatLng(-6.288426, 106.870878),
                                new LatLng(-6.288795, 106.870959),
                                new LatLng(-6.289067, 106.871035),
                                new LatLng(-6.289502, 106.871182),
                                new LatLng(-6.290108, 106.871363),
                                new LatLng(-6.290810, 106.871580),
                                new LatLng(-6.291855, 106.871891),
                                new LatLng(-6.292825, 106.872128),
                                new LatLng(-6.293080, 106.872170),
                                new LatLng(-6.293409, 106.872184),
                                new LatLng(-6.293700, 106.872173),
                                new LatLng(-6.294956, 106.871954),
                                new LatLng(-6.295932, 106.871778),
                                new LatLng(-6.296936, 106.871435),
                                new LatLng(-6.297801, 106.871062),
                                new LatLng(-6.298338, 106.870850),
                                new LatLng(-6.298850, 106.870583),
                                new LatLng(-6.299200, 106.870335),
                                new LatLng(-6.300600, 106.869200),
                                new LatLng(-6.301314, 106.868614),
                                new LatLng(-6.301378, 106.868555),
                                new LatLng(-6.301762, 106.868221),
                                new LatLng(-6.301881, 106.868134),
                                new LatLng(-6.302693, 106.867502),
                                new LatLng(-6.302839, 106.867397),
                                new LatLng(-6.303169, 106.867101),
                                new LatLng(-6.303457, 106.866871),
                                new LatLng(-6.303573, 106.866833),
                                new LatLng(-6.303666, 106.866779),
                                new LatLng(-6.304393, 106.866262),
                                new LatLng(-6.304643, 106.866105),
                                new LatLng(-6.305553, 106.865622),
                                new LatLng(-6.305624, 106.865589),
                                new LatLng(-6.305668, 106.865602),
                                new LatLng(-6.305802, 106.865572),
                                new LatLng(-6.305912, 106.865552),
                                new LatLng(-6.306027, 106.865576),
                                new LatLng(-6.306410, 106.865757),
                                new LatLng(-6.306580, 106.866103),
                                new LatLng(-6.307330, 106.867499),
                                new LatLng(-6.307426, 106.867653),
                                new LatLng(-6.307489, 106.867924),
                                new LatLng(-6.307555, 106.868079),
                                new LatLng(-6.307589, 106.868151),
                                new LatLng(-6.307935, 106.868696),
                                new LatLng(-6.308177, 106.869214),
                                new LatLng(-6.308256, 106.869483),
                                new LatLng(-6.308332, 106.869742),
                                new LatLng(-6.308401, 106.870181),
                                new LatLng(-6.308397, 106.870895),
                                new LatLng(-6.307809, 106.873866),
                                new LatLng(-6.307413, 106.875365),
                                new LatLng(-6.307210, 106.876077),
                                new LatLng(-6.306992, 106.876886),
                                new LatLng(-6.306703, 106.877971),
                                new LatLng(-6.306549, 106.878727)

                        ).width(10).color(Color.YELLOW)
        );
        polyline4.setClickable(true);
        p4=polyline4.getId();


    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Maps Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://root.sari.project.maps/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Maps Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://root.sari.project.maps/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    @Override
    public void onLocationChanged(Location location) {

        // Getting latitude of the current location
        double latitude = location.getLatitude();

        // Getting longitude of the current location
        double longitude = location.getLongitude();

        // Creating a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);

        // Showing the current location in Google Map
        gMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        // Zoom in the Google Map
        gMap.animateCamera(CameraUpdateFactory.zoomTo(15));


    }

    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub
    }
}

