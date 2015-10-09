package org.ei.telemedicine.test.doctor;


import android.content.Intent;
import android.os.Bundle;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.MediumTest;

import org.ei.telemedicine.R;
import org.ei.telemedicine.doctor.DoctorFormDataConstants;
import org.ei.telemedicine.doctor.DoctorPlanofCareActivity;
import org.ei.telemedicine.view.customControls.CustomFontTextView;
import org.json.JSONObject;

public class DoctorPlanofCareActivityTest extends ActivityUnitTestCase<DoctorPlanofCareActivity> {


    private DoctorPlanofCareActivity doctorPlanofCareActivity;
    private CustomFontTextView tv_mother_name,tv_age,tv_visit_type,tv_village,tv_health_worker_name,tv_health_worker_village;

    private String tv_mother_name_string = "tv_mother_name_string";
    private String tv_age_string = "tv_age_string";
    private String tv_visit_type_string = "tv_visit_type_string";
    private String tv_village_string = "tv_village_string";
    private String tv_anmid_string = "tv_anmid_string";


    Intent mLaunchIntent;
    public DoctorPlanofCareActivityTest(){
        super(DoctorPlanofCareActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mLaunchIntent = new Intent(getInstrumentation().getTargetContext(), DoctorPlanofCareActivity.class);
        mLaunchIntent.putExtras(getBundleExtra());
        startActivity(mLaunchIntent, null, null);

        doctorPlanofCareActivity = getActivity();
        setUpViews();

    }

    private void setUpViews() {

        tv_mother_name = (CustomFontTextView) doctorPlanofCareActivity.findViewById(R.id.tv_mother_name);
        tv_age = (CustomFontTextView) doctorPlanofCareActivity.findViewById(R.id.tv_age);
        tv_visit_type = (CustomFontTextView) doctorPlanofCareActivity.findViewById(R.id.tv_visit_type);
        tv_village = (CustomFontTextView) doctorPlanofCareActivity.findViewById(R.id.tv_village);
        tv_health_worker_name = (CustomFontTextView) doctorPlanofCareActivity.findViewById(R.id.tv_health_worker_name);
        tv_health_worker_village = (CustomFontTextView) doctorPlanofCareActivity.findViewById(R.id.tv_health_worker_village_name);

    }

    public Bundle getBundleExtra() {
        Bundle mBundle = new Bundle();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(DoctorFormDataConstants.wife_name, tv_mother_name_string);
            jsonObject.put(DoctorFormDataConstants.age, tv_age_string);
            jsonObject.put(DoctorFormDataConstants.visit_type, tv_visit_type_string);
            jsonObject.put(DoctorFormDataConstants.village_name, tv_village_string);
            jsonObject.put(DoctorFormDataConstants.anmId, tv_anmid_string);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mBundle.putString(DoctorFormDataConstants.formData, jsonObject + "");
        return  mBundle;

    }

    @MediumTest
    public void testDataSetToViews(){
        assertEquals(tv_mother_name.getText() + "", tv_mother_name_string);
        assertEquals(tv_age.getText().toString(),  tv_age_string);
        assertEquals(tv_visit_type.getText().toString(), tv_visit_type_string);
        assertEquals(tv_village.getText().toString(), tv_village_string);
        assertEquals(tv_health_worker_name.getText().toString(), tv_anmid_string);
        assertEquals(tv_health_worker_village.getText().toString(), tv_village_string);
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
