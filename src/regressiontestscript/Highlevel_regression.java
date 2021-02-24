package regressiontestscript;

import org.testng.annotations.Test;

import pom_iAdmin.AdhocForm;
import pom_iAdmin.Adhoc_Export;
import pom_iAdmin.Adhoc_copy_form;
import pom_iAdmin.Adhoc_hyperlink;
import pom_iAdmin.Adhoc_scheduler;
import pom_iAdmin.App_config;
import pom_iAdmin.App_theme;
import pom_iAdmin.Banner;
import pom_iAdmin.Datadescription;
import pom_iAdmin.Layer_menu;
import pom_iAdmin.Login_page;
import pom_iAdmin.Media_Library;
import pom_iAdmin.Menu_rearrangement;
import pom_iAdmin.Offlinedata;
import pom_iAdmin.Social_media_page;
import pom_iAdmin.Submenu_config;
import GenericMethods.ExcelGeneric;
import GenericMethods.Filemanager;
import GenericMethods.Generictest;

public class Highlevel_regression extends Generictest {
	@Test(priority = 2)
	public void validloginlogout_session1() throws Throwable {
		// run in chrome
		String uname = ExcelGeneric.Excelread("ValidLogin", 1, 0);
		String pswd = ExcelGeneric.Excelread("ValidLogin", 1, 1);

		String url = Filemanager.getapplnurl();
		driver.get(url);
		Login_page lp = new Login_page(driver);
		test = reports.createTest("validLoginlogout",
				"To validate user name and password");
		test.info("Test case has been started");
		test.pass("Launched the browser and navigated to iAdmin");
		test.addScreenCaptureFromPath(Photo_path);
		lp.Sendusername(uname);
		test.pass("Entered the email id of the admin");
		lp.sendpassword(pswd);
		test.pass("Entered the password");
		lp.signin();
		test.pass("Clicked on signin button");
		lp.sessionpopup();
		test.pass("Accepted the session related pop up");
		lp.Instituteselection();
		test.pass("Selected the institute");

		
		  App_config config = new App_config(driver); config.Clickappmmenu();
		  config.max_limit_reached();
		  test.pass("Successfully added the new menu.");
		  
		  Submenu_config submenu = new Submenu_config(driver);
		  submenu.Addsubmenu();
		  test.pass("Successfully added the action for the app menu.");
		  
		  Layer_menu Layermenu = new Layer_menu(driver);
		  Layermenu.Extend_app_config();
		  test.pass("Expanded the app config tab");
		  Layermenu.Layer_menu_page();
		  test.pass("Navigated to the layer menu page");
		  Layermenu.app_menu_dropdown();
		  test.pass("Selected the second element from the app menu drop down");
		  Layermenu.sub_menu_dropdown();
		  test.pass("Selected the second element from the sub menu drop down");
		  Layermenu.layer_menu_dropdown();
		  test.pass("Selected the notification as action from layer menu drop down");
		  Layermenu.save_layer_menu();
		  test.pass("Saved the layer menu action");
		  
		  Datadescription data_descr = new Datadescription(driver);
		  data_descr.Extend_app_config();
		  test.pass("Expanded the app config tab");
		  data_descr.Datadescription_page();
		  test.pass("Navigated to the data description menu page");
		  data_descr.app_menu_dropdown();
		  test.pass("Selected the first element from the app menu drop down");
		 data_descr.sub_menu_dropdown();
		  test.pass("Selected the first element from the sub menu drop down");
		  data_descr.layer_menu_dropdown();
		  test.pass("Selected the first element from the layer menu drop down"
		  ); data_descr.Datadescrpn_menu_dropdown();
		  test.pass("Selected the notification as action from layer menu drop down"
		  ); data_descr.save_datadescr_menu();
		  test.pass("Saved the layer menu action");
		  
		  
		  Menu_rearrangement menu_rearrange = new Menu_rearrangement(driver);
		  menu_rearrange.app_config();
		  test.pass("mouse hovered the app config tab");
		  menu_rearrange.menurearrangement();
		  test.pass("clicked on  menu re-arrangement option");
		  menu_rearrange.page_confirmation(); test.pass("Confirmed the page");
		  menu_rearrange.drag_and_drop();
		  test.pass("Dropped the element to the specified location");
		  menu_rearrange.Save_menu_rearrangemnet();
		  test.pass("Saved the dragged menu");
		  
		  Social_media_page socialmedia= new Social_media_page(driver);
		  socialmedia.app_config_tab();
		  test.pass("mouse hovered the app config tab");
		  socialmedia.social_media();
		  test.pass("clicked on social media option");
		  socialmedia.social_media_fb_selection();
		  test.pass("Social media has been saved with fb option");
		  
		  Media_Library medialib = new Media_Library(driver);
		  medialib.Extend_app_config();
		  test.pass("mouse hovered the app config tab");
		  medialib.medialibrary_page();
		  test.pass("clicked on media library option"); medialib.upload_logo();
		  test.pass("uploaded the logo");
		  
		  Offlinedata offline = new Offlinedata(driver);
		  offline.Extend_app_config();
		  test.pass("mouse hovered the app config tab");
		  offline.offline_page(); test.pass("navigated to offline page");
		  offline.Add_New_button_click();
		  test.pass("clicked on new button to add the offline data");
		  
		  Banner banner = new Banner(driver); banner.Extend_app_config();
		  test.pass("mouse hovered the app config tab"); banner.banner_page();
		  test.pass("navigated to banner page"); banner.Add_banner();
		  test.pass("Added banner successfully");
		  
		  App_theme apptheme = new App_theme(driver);
		  apptheme.Extend_app_config();
		  test.pass("mouse hovered the app config tab");
		  apptheme.apptheme_page(); test.pass("navigated to app theme page");
		  apptheme.select_theme(); test.pass("save the BG color theme");
		  
		  AdhocForm adhoc = new AdhocForm(driver); adhoc.Expand_adhoc();
		  test.pass("mouse hovered to the adhoc tab"); adhoc.adhoc_page();
		  test.pass("selected adhoc module "); adhoc.status();
		  //adhoc.Record_details(); adhoc.Add_adhoc();
		  test.pass("Added a new adhoc form ");
		  adhoc.add_fields_to_adhocform();
		  test.pass("Added fields to the adhoc form ");
		 
		
		Adhoc_copy_form copy_adhoc = new Adhoc_copy_form(driver);
		copy_adhoc.Expand_adhoc();
		test.pass("mouse hovered to the adhoc tab");
		copy_adhoc.adhoc_page();
		test.pass("selected adhoc module ");
		copy_adhoc.click_copy_adhoc();
		test.pass("adhoc copy functionality");

		Adhoc_Export export = new Adhoc_Export(driver);
		export.multiexport();
		export.select_chkbox2export();
		export.select_record_entry();
		export.select_record_chk();
		export.export_config();
		
		Adhoc_hyperlink hyperlink = new Adhoc_hyperlink(driver);
		hyperlink.Hyperlink_adhoc();
		hyperlink.Add_user_record();
		hyperlink.Response_add_userrecord();
		
		
		Adhoc_scheduler scheduler = new Adhoc_scheduler(driver);
		scheduler.Expand_adhoc();
		scheduler.sch_page();
		scheduler.Adhoc_sch();
		scheduler.Adhoc_sch_details();
		
	}
}
