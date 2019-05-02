# Lab4-SettingActivity
## Description: 
Setting activity.
## Core code:
```
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new PrefFragment())
                .commit();
    }
}

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

<?xml version="1.0" encoding="utf-8"?>
<PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android">

    <PreferenceCategory
        android:key="In-line preferences"
        android:summary="In-line preferences"
        android:title="In-line preferences">
        <CheckBoxPreference
            android:key="wireless_network"
            android:summary="This is a checkbox"
            android:title="CheckBoxPreference" />
    </PreferenceCategory>
    <PreferenceCategory
        android:layout_height="wrap_content"
        android:key="Dialog-based preferences:"
        android:summary="Dialog-based preferences:"
        android:title="Dialog-based preferences:">
        <EditTextPreference
            android:dialogTitle="Enter your favorite animal"
            android:key="text"
            android:summary="An example that uses an edit text dialog"
            android:title="EditTextPreference" />
        <ListPreference
            android:dialogTitle="Choose one"
            android:entries="@array/cities"
            android:entryValues="@array/cities"
            android:key="List preference"
            android:summary="An example that uses a list dialog"
            android:title="List preference" />
    </PreferenceCategory>
    <PreferenceCategory
        android:layout_height="wrap_content"
        android:title="Launch preferences">
        <PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android"
            android:persistent="false"
            android:summary="Shows another screen of preferences"
            android:title="Screen preference">
            <CheckBoxPreference
                android:defaultValue="false"
                android:summary="Preference that is on the next screen but same hierarchy"
                android:title="Toggle preference"></CheckBoxPreference>
        </PreferenceScreen>
        <Preference android:title="Intent preference"
            android:summary="Launches an activity from an Intent"
            >
            <intent android:action="android.intent.action.VIEW"
                android:data="http://www.baidu.com" />
        </Preference>
    </PreferenceCategory>
    <PreferenceCategory
        android:title="Preference attributes" >
        <CheckBoxPreference
            android:checked="false"
            android:key="Parent-checkbox-preference"
            android:summary="This is visually a parent"
            android:title="Parent checkbox preference" />
        <CheckBoxPreference
            android:key="Child-checkbox-preference"
            android:summary="This is visually a child"
            android:title="Child checkbox preference" />
    </PreferenceCategory>

</PreferenceScreen>
```
## Screenshots:<br>
![This picture is stored in the folder of images.](https://github.com/huhuhuu/Lab4-SettingActivity/blob/master/images/main.PNG)<br>
![This picture is stored in the folder of images.](https://github.com/huhuhuu/Lab4-SettingActivity/blob/master/images/EditTextPreference.PNG)<br>
![This picture is stored in the folder of images.](https://github.com/huhuhuu/Lab4-SettingActivity/blob/master/images/ListPreference.PNG)<br>
![This picture is stored in the folder of images.](https://github.com/huhuhuu/Lab4-SettingActivity/blob/master/images/ScreenPreference.PNG)<br>
![This picture is stored in the folder of images.](https://github.com/huhuhuu/Lab4-SettingActivity/blob/master/images/IntentPreference.PNG)<br>
![This picture is stored in the folder of images.](https://github.com/huhuhuu/Lab4-SettingActivity/blob/master/images/ParentChecked.PNG)<br>
![This picture is stored in the folder of images.](https://github.com/huhuhuu/Lab4-SettingActivity/blob/master/images/ParentNoChecked.PNG)<br>
