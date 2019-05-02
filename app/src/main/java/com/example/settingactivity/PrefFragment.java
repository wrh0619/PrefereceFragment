package com.example.settingactivity;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;

public class PrefFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
        CheckBoxPreference childCheckBoxPreference = (CheckBoxPreference)findPreference("Child-checkbox-preference");
        //让childCheckBoxPreference和parentCheckBoxPreference的状态保持一致
        childCheckBoxPreference.setEnabled(false);
    }
    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
                                         Preference preference) {
        //第一个checkbox选中，则执行
        if("Parent-checkbox-preference".equals(preference.getKey())) {
            CheckBoxPreference parentCheckBoxPreference = (CheckBoxPreference)findPreference("Parent-checkbox-preference");
            CheckBoxPreference childCheckBoxPreference = (CheckBoxPreference)findPreference("Child-checkbox-preference");
            //让childCheckBoxPreference和parentCheckBoxPreference的状态保持一致
            if (parentCheckBoxPreference.isChecked() == true) {
                childCheckBoxPreference.setEnabled(true);
            }
            else {
                childCheckBoxPreference.setEnabled(false);
            }
            CheckBoxPreference childCheckBoxPreference1 = (CheckBoxPreference) findPreference("Child-checkbox-preference");
        }
        // TODO Auto-generated method stub
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }
}