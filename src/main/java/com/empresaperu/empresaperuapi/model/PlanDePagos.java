package com.empresaperu.empresaperuapi.model;

public class PlanDePagos {
    private int NDxA; // Numero de dias por anio (360 por ser vencido ordinario)
    private String T; // Tipo de tasa a ingresar
    private double TEA; // Tasa efectiva anual
    private double TEP; // Tasa efectiva del periodo
    private double PV; // Precio de venta del bien
    private double pCI; // Porcentaje de cuota inicial (en %, no en decimales)
    private int Frec; // Frecuencia de pago (cada 30 dias por ser vencido ordinario)
    private int NA; // Numero de anios durante los que se pagara
    private double CI; // Cuota inicial (numero, ya no porcentaje)
    private double C; // Cantidad del prestamo
    private int NCxA; // Numero de cuotas por anio (12 por ser vencido ordinario)
    private int N; // Numero total de cuotas (numero de cuotas por anio * numero de anios)
    private String PG; // Tipo de periodo de gracia
    private int NPG; // Cantidad de periodos que abarca el periodo de gracia
    private int NC; // Numero actual de cuota
    private double R; // Cuota del periodo
    private double R2; // Cuota delta de R
    private double I; // Interes del periodo
    private double A; // Amortizacion del periodo
    private double SI; // Saldo inicial del periodo
    private double SF; // Saldo final del periodo
    private double RT; // Cuota total
    private double AT; // Amortizacion total
    private double IT; // Interes total
    private double CN; // Costos notariales
    private double CR; // Costos registrales
    private double TSD; // Tasa del seguro de desgravamen
    private double TSDA; // Tasa del seguro de desgravamen anual
    private double TSDP; // Tasa del seguro de desgravamen ajustada al plazo (mensual)
    private double SD; // Valor monetario del seguro de desgravamen
    private double TSR; // Tasa del seguro contra todo riesgo
    private double TSRA; // Tasa del seguro contra todo riesgo anual
    private double TSRP; // Tasa del seguro contra todo riesgo ajustada al plazo (mensual)
    private double SR; // Valor monetario del seguro contra todo riesgo
    private double GA; // Gastos administrativo
    private double P; // Portes
    private double VPSF; // Valor presente del saldo final
    private double CP; // Comision periodica
    private int vueltas; // Numero de veces que se ha repetido el plan de pagos
    private double AUX; // Variable auxiliar
    private double AUX2; // Variable auxiliar 2
    private double AUX3; // Variable auxiliar 3

    public PlanDePagos() {
        this.NDxA = 0;
        this.T = "";
        this.TEA = 0.0;
        this.TEP = 0.0;
        this.PV = 0.0;
        this.pCI = 0.0;
        this.Frec = 0;
        this.NA = 0;
        this.CI = 0.0;
        this.C = 0.0;
        this.NCxA = 0;
        this.N = 0;
        this.PG = "";
        this.NPG = 0;
        this.NC = 0;
        this.R = 0.0;
        this.R2 = 0.0;
        this.I = 0.0;
        this.A = 0.0;
        this.SI = 0.0;
        this.SF = 0.0;
        this.RT = 0.0;
        this.AT = 0.0;
        this.IT = 0.0;
        this.CN = 0.0;
        this.CR = 0.0;
        this.TSD = 0.0;
        this.TSDA = 0.0;
        this.TSDP = 0.0;
        this.SD = 0.0;
        this.TSR = 0.0;
        this.TSRA = 0.0;
        this.TSRP = 0.0;
        this.SR = 0.0;
        this.GA = 0.0;
        this.P = 0.0;
        this.VPSF = 0.0;
        this.CP = 0.0;
        this.vueltas = 0;
        this.AUX = 0.0;
        this.AUX2 = 0.0;
        this.AUX3 = 0.0;
    }

    public int getNDxA() {
        return NDxA;
    }

    public void setNDxA(int NDxA) {
        this.NDxA = NDxA;
    }

    public String getT() {
        return T;
    }

    public void setT(String T) {
        this.T = T;
    }

    public double getTEA() {
        return TEA;
    }

    public void setTEA(double TEA) {
        this.TEA = TEA;
    }

    public double getTEP() {
        return TEP;
    }

    public void setTEP(double TEP) {
        this.TEP = TEP;
    }

    public double getPV() {
        return PV;
    }

    public void setPV(double PV) {
        this.PV = PV;
    }

    public double getPCI() {
        return pCI;
    }

    public void setPCI(double pCI) {
        this.pCI = pCI;
    }

    public int getFrec() {
        return Frec;
    }

    public void setFrec(int Frec) {
        this.Frec = Frec;
    }

    public int getNA() {
        return NA;
    }

    public void setNA(int NA) {
        this.NA = NA;
    }

    public double getCI() {
        return CI;
    }

    public void setCI(double CI) {
        this.CI = CI;
    }

    public double getC() {
        return C;
    }

    public void setC(double C) {
        this.C = C;
    }

    public int getNCxA() {
        return NCxA;
    }

    public void setNCxA(int NCxA) {
        this.NCxA = NCxA;
    }

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }

    public String getPG() {
        return PG;
    }

    public void setPG(String PG) {
        this.PG = PG;
    }

    public int getNPG() {
        return NPG;
    }

    public void setNPG(int NPG) {
        this.NPG = NPG;
    }

    public int getNC() {
        return NC;
    }

    public void setNC(int NC) {
        this.NC = NC;
    }

    public double getR() {
        return R;
    }

    public void setR(double R) {
        this.R = R;
    }

    public double getR2() {
        return R2;
    }

    public void setR2(double R2) {
        this.R2 = R2;
    }

    public double getI() {
        return I;
    }

    public void setI(double I) {
        this.I = I;
    }

    public double getA() {
        return A;
    }

    public void setA(double A) {
        this.A = A;
    }

    public double getSI() {
        return SI;
    }

    public void setSI(double SI) {
        this.SI = SI;
    }

    public double getSF() {
        return SF;
    }

    public void setSF(double SF) {
        this.SF = SF;
    }

    public double getRT() {
        return RT;
    }

    public void setRT(double RT) {
        this.RT = RT;
    }

    public double getAT() {
        return AT;
    }

    public void setAT(double AT) {
        this.AT = AT;
    }

    public double getIT() {
        return IT;
    }

    public void setIT(double IT) {
        this.IT = IT;
    }

    public double getCN() {
        return CN;
    }

    public void setCN(double CN) {
        this.CN = CN;
    }

    public double getCR() {
        return CR;
    }

    public void setCR(double CR) {
        this.CR = CR;
    }

    public double getTSD() {
        return TSD;
    }

    public void setTSD(double TSD) {
        this.TSD = TSD;
    }

    public double getTSDA() {
        return TSDA;
    }

    public void setTSDA(double TSDA) {
        this.TSDA = TSDA;
    }

    public double getTSDP() {
        return TSDP;
    }

    public void setTSDP(double TSDP) {
        this.TSDP = TSDP;
    }

    public double getSD() {
        return SD;
    }

    public void setSD(double SD) {
        this.SD = SD;
    }

    public double getTSR() {
        return TSR;
    }

    public void setTSR(double TSR) {
        this.TSR = TSR;
    }

    public double getTSRA() {
        return TSRA;
    }

    public void setTSRA(double TSRA) {
        this.TSRA = TSRA;
    }

    public double getTSRP() {
        return TSRP;
    }

    public void setTSRP(double TSRP) {
        this.TSRP = TSRP;
    }

    public double getSR() {
        return SR;
    }

    public void setSR(double SR) {
        this.SR = SR;
    }

    public double getGA() {
        return GA;
    }

    public void setGA(double GA) {
        this.GA = GA;
    }

    public double getP() {
        return P;
    }

    public void setP(double P) {
        this.P = P;
    }

    public double getVPSF() {
        return VPSF;
    }

    public void setVPSF(double VPSF) {
        this.VPSF = VPSF;
    }

    public double getCP() {
        return CP;
    }

    public void setCP(double CP) {
        this.CP = CP;
    }

    public int getVueltas() {
        return vueltas;
    }

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }

    public double getAUX() {
        return AUX;
    }

    public void setAUX(double AUX) {
        this.AUX = AUX;
    }

    public double getAUX2() {
        return AUX2;
    }

    public void setAUX2(double AUX2) {
        this.AUX2 = AUX2;
    }

    public double getAUX3() {
        return AUX3;
    }

    public void setAUX3(double AUX3) {
        this.AUX3 = AUX3;
    }
}