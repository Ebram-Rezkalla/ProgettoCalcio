package model;

public class StatsGeneraliModel {
	 int Max;
	 int Min;
	 double Medio;
	 int StagMesi;
	 int StagGiorni;
	 double StagSalvate;
	
	 public StatsGeneraliModel(int max, int min, double medio, int stagMesi, int stagGiorni, double stagSalvate) {
		Max = max;
		Min = min;
		Medio = medio;
		StagMesi = stagMesi;
		StagGiorni = stagGiorni;
		StagSalvate = stagSalvate;
	}

	public int getMax() {
		return Max;
	}

	public void setMax(int max) {
		Max = max;
	}

	public int getMin() {
		return Min;
	}

	public void setMin(int min) {
		Min = min;
	}

	public double getMedio() {
		return Medio;
	}

	public void setMedio(double medio) {
		Medio = medio;
	}

	public int getStagMesi() {
		return StagMesi;
	}

	public void setStagMesi(int stagMesi) {
		StagMesi = stagMesi;
	}

	public int getStagGiorni() {
		return StagGiorni;
	}

	public void setStagGiorni(int stagGiorni) {
		StagGiorni = stagGiorni;
	}

	public double getStagSalvate() {
		return StagSalvate;
	}

	public void setStagSalvate(double stagSalvate) {
		StagSalvate = stagSalvate;
	}



}