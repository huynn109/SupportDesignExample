package huynn109.com.supportdesignexample;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.glide.slider.library.Animations.DescriptionAnimation;
import com.glide.slider.library.SliderLayout;
import com.glide.slider.library.SliderTypes.BaseSliderView;
import com.glide.slider.library.SliderTypes.TextSliderView;
import com.glide.slider.library.Tricks.ViewPagerEx;
import java.util.HashMap;

public class ScrollingActivity extends AppCompatActivity {

  private SliderLayout mDemoSlider;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scrolling);
    final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayShowTitleEnabled(false);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    mDemoSlider = (SliderLayout) findViewById(R.id.slider);
    HashMap<String, String> url_maps = new HashMap<String, String>();
    url_maps.put("Hannibal",
        "https://vcdn.tikicdn.com/cache/550x550/media/catalog/product/1/_/1.u2470.d20170329.t095817.343939.jpg");
    url_maps.put("Big Bang Theory",
        "https://vcdn.tikicdn.com/cache/550x550/media/catalog/product/2/_/2.u2470.d20170329.t095817.387681.jpg");
    url_maps.put("House of Cards",
        "https://vcdn.tikicdn.com/cache/550x550/media/catalog/product/3/_/3.u2470.d20170329.t095817.426070.jpg");
    for (String name : url_maps.keySet()) {
      TextSliderView textSliderView = new TextSliderView(this);
      // initialize a SliderLayout
      textSliderView
          .description(name)
          .image(url_maps.get(name))
          .setCenterCrop(false)
          .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override public void onSliderClick(BaseSliderView baseSliderView) {

            }
          });

      //add your extra information
      textSliderView.bundle(new Bundle());
      textSliderView.getBundle()
          .putString("extra", name);

      mDemoSlider.addSlider(textSliderView);
    }
    mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
    mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
    mDemoSlider.setCustomAnimation(new DescriptionAnimation());
    mDemoSlider.setDuration(4000);
    mDemoSlider.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
      @Override public void onPageScrolled(int i, float v, int i1) {

      }

      @Override public void onPageSelected(int i) {

      }

      @Override public void onPageScrollStateChanged(int i) {

      }
    });
    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
      }
    });

    final CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
    AppBarLayout appBar= (AppBarLayout)  findViewById(R.id.app_bar);
    appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
      @Override
      public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if ((collapsingToolbar.getHeight() + verticalOffset) < collapsingToolbar.getScrimVisibleHeightTrigger()) {
          toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        } else {
          toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
        }
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_scrolling, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
