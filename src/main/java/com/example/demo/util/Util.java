package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	public static String GetDate() {
		return new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss").format(new Date());
	}
}
