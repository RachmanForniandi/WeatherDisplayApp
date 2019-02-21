package rachmanforniandi.com.weatherdisplayapp.Models;

import com.google.gson.annotations.SerializedName;

public class Currently{

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@SerializedName("summary")
	private String summary;

	@SerializedName("icon")
	private String icon;

	@SerializedName("temperature")
	private double temperature;

	@SerializedName("time")
	private int time;

}