package com.ailaptopmall.entity;

import java.time.LocalDate;

public class Product {

	private int id; // PKey(equals + hashCode), AUTO-INCREMENT

	private String name; // unique, required, 1~60個字元

	private double unitPrice; // required, >0 , 定價(售價)

	private int stock; // required，負數

	private String photoUrl; // optional

	private String category; // 總類, required, null,""~250個字元

	private String description = ""; // optional, 0~250個字元

	private LocalDate releaseDate; // required
}
