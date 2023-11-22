module njuice {
	exports main;
	opens main;
	exports dashboard;
	opens dashboard;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
}