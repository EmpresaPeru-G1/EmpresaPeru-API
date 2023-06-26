package com.empresaperu.empresaperuapi.model;

import java.util.ArrayList;
import java.util.List;

public class EjecutarPDP {
	private PlanDePagos plan;
	private DataPDP data;
	public List<ResponsePDP> list = new ArrayList<ResponsePDP>();

    public EjecutarPDP(PlanDePagos plan, DataPDP data) {
        this.plan = plan;
        this.data = data;
    }
    public List<ResponsePDP> PDP() {
        while (this.plan.getNC() <= this.plan.getN()) {
            if (this.plan.getNC() == 1) {
                this.plan.setSI(this.plan.getAUX3());
            } else {
                this.plan.setSI(this.plan.getSF());
            }

            this.plan.setI(this.plan.getTEP() * this.plan.getSI());

            if (this.plan.getNC() <= this.plan.getNPG() && this.plan.getPG().equals("T")) {
                this.plan.setSD(this.plan.getC() * this.plan.getTSDP());
                this.plan.setSR(this.plan.getPV() * this.plan.getTSRP());
                this.plan.setR(0);
                this.plan.setA(0);
                this.plan.setSF(this.plan.getSI() + this.plan.getI());
                this.plan.setC(this.plan.getSF());
            } else if (this.plan.getNC() <= this.plan.getNPG() && this.plan.getPG().equals("P")) {
                this.plan.setSD(this.plan.getC() * this.plan.getTSDP());
                this.plan.setSR(this.plan.getPV() * this.plan.getTSRP());
                this.plan.setR(this.plan.getI());
                this.plan.setA(0);
                this.plan.setSF(this.plan.getSI());
            } else {
                this.plan.setSD(this.plan.getC() * this.plan.getTSDP());
                this.plan.setSR(this.plan.getPV() * this.plan.getTSRP());

                
                
                if (this.plan.getVueltas() == 0) {
                    this.plan.setR(this.plan.getC() * (this.plan.getTEP() * Math.pow(1 + this.plan.getTEP(), this.plan.getN() - this.plan.getNPG())) / (Math.pow(1 + this.plan.getTEP(), this.plan.getN() - this.plan.getNPG()) - 1));
                    this.plan.setAUX2(this.plan.getC());
                } else {
                    this.plan.setR(this.plan.getAUX());
                }

                this.plan.setA(this.plan.getR() - this.plan.getI() - this.plan.getSD() - this.plan.getSR() - this.plan.getGA() - this.plan.getCP() - this.plan.getP());
                this.plan.setSF(this.plan.getSI() - this.plan.getA());
            }

            this.plan.setRT(this.plan.getRT() + this.plan.getR());
            this.plan.setAT(this.plan.getAT() + this.plan.getA());
            
            /*
             * 
             * N\tTEA\t\tTEP\t\tSaldo Inicial\t\tIntereses\t\tCuota\t\tAmortizacion\t\tSD\t\tSR\t\tSaldo Final")
             */

            /*System.out.println(String.format("%d\t%.7f%%\t%.7f%%\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f",
                    this.plan.getNC(), this.plan.getTEA() * 100, this.plan.getTEP() * 100, this.plan.getSI(), this.plan.getI(), this.plan.getR(), this.plan.getA(),
                    this.plan.getSD(), this.plan.getSR(), this.plan.getGA(), this.plan.getCP(), this.plan.getP(), this.plan.getSF()));
                    */// ----------------------IMPORTANTE SALIDA DE DATOS (TABLA)
            ResponsePDP response = new ResponsePDP();
            response.setNroCuota(this.plan.getNC());
            response.setTea(this.plan.getTEA() * 100);
            response.setTep(this.plan.getTEP() * 100);
            response.setSaldoInicial(this.plan.getSI());
            response.setIntereses(this.plan.getI());
            response.setCuota(this.plan.getR());
            response.setAmortizacion(this.plan.getA());
            response.setSeguroDegravamen(this.plan.getSD());
            response.setSeguroTodoRiesgo(this.plan.getSR());
            response.setGastosAdministrativos(this.plan.getGA());
            response.setComisionPeriodica(this.plan.getCP());
            response.setPortes(this.plan.getP());
            response.setSaldoFinalPeriodo(this.plan.getSF());
            list.add(response);

            this.plan.setNC(this.plan.getNC() + 1);
        }

        while (Math.round(this.plan.getSF() * 100.0) / 100.0 != 0.00) {
            this.plan.setVPSF(this.plan.getSF() / Math.pow(1 + this.plan.getTEA(), this.plan.getNA()));
            this.plan.setR2(this.plan.getVPSF() * (this.plan.getTEP() * Math.pow(1 + this.plan.getTEP(), this.plan.getN() - this.plan.getNPG())) / (Math.pow(1 + this.plan.getTEP(), this.plan.getN() - this.plan.getNPG()) - 1));
            this.plan.setR(this.plan.getR() + this.plan.getR2());
            this.plan.setAUX(this.plan.getR());
            this.plan.setC(this.plan.getAUX2());

            this.plan.setNC(1);
            this.plan.setVueltas(this.plan.getVueltas()+1);
            PDP();
        }

        this.plan.setIT(this.plan.getRT() - this.plan.getAT());
        return list;
    }


    public void correr(){
        this.plan.setNDxA(360);
        this.plan.setFrec(30);
        this.plan.setNCxA(12);

        // A PARTIR DE AQUI SE LEEN Y VALIDAN LOS DATOS INICIALES

        // ENTRADA DATOS: TIPO DE TASA
        /*
        Scanner scanner = new Scanner(System.in);

        // Ingresar y validar el tipo y el valor de la tasa
        System.out.print("Ingrese el tipo de tasa de su preferencia (Si es Efectiva ingrese E y si es Nominal ingrese N): ");
        String t = scanner.nextLine();
        while (!t.equalsIgnoreCase("E") && !t.equalsIgnoreCase("N")) {
            System.out.print("El tipo de tasa solo puede ser Efectiva (E) o Nominal (N). Ingrese el tipo de tasa correctamente: ");
            t = scanner.nextLine();
        }
        
        scanner.close();
        */

        // Asignar el valor al atributo T de la instancia de la clase PlanDePagos
        var t = data.tipoDeTasa;
        this.plan.setT(t);

        double vte = 0.0;

        if (this.plan.getT().equalsIgnoreCase("E")) {
        	try {
        		vte = data.valorTasaEfectiva;
                if (vte < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\nError: El valor de la tasa efectiva debe ser un numero mayor o igual a cero con o sin decimales.\n");
            }
            /*while (true) {
                Scanner input = new Scanner(System.in);
                System.out.print("Ingrese el valor de la tasa efectiva dividida entre 100: "); //Valor de la tasa efectiva
                try {
                    vte = Double.parseDouble(input.nextLine());
                    if (vte < 0) {
                        throw new IllegalArgumentException();
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("\nError: El valor de la tasa efectiva debe ser un numero mayor o igual a cero con o sin decimales.\n");
                }
            }*/// ENTRADA DE USUARIO ---> Valor de la tasa efectiva

            /*ENTRADA DE USUARIO -------> TIPO TASA EFECTIVA
             * 
             * 
             * Scanner scanner2 = new Scanner(System.in);
            String te;
            System.out.print("Ingrese el tipo de Tasa Efectiva:\n" +
                    "Tasa Efectiva Anual (TEA)\n" +
                    "Tasa Efectiva Semestral (TES)\n" +
                    "Tasa Efectiva Cuatrimestral (TEC)\n" +
                    "Tasa Efectiva Trimestral (TET)\n" +
                    "Tasa Efectiva Bimestral (TEB)\n" +
                    "Tasa Efectiva Mensual (TEM)\n" +
                    "Tasa Efectiva Quincenal (TEQ)\n" +
                    "Tasa Efectiva Diaria (TED)\n" +
                    "Tipo de Tasa Efectiva: ");
            te = scanner2.nextLine();

            while (!te.equalsIgnoreCase("TEA") && !te.equalsIgnoreCase("TES") && !te.equalsIgnoreCase("TEC") &&
                    !te.equalsIgnoreCase("TET") && !te.equalsIgnoreCase("TEB") && !te.equalsIgnoreCase("TEM") &&
                    !te.equalsIgnoreCase("TEQ") && !te.equalsIgnoreCase("TED")) {
                System.out.print("Ingrese el tipo de Tasa Efectiva:\n" +
                        "Tasa Efectiva Anual (TEA)\n" +
                        "Tasa Efectiva Semestral (TES)\n" +
                        "Tasa Efectiva Cuatrimestral (TEC)\n" +
                        "Tasa Efectiva Trimestral (TET)\n" +
                        "Tasa Efectiva Bimestral (TEB)\n" +
                        "Tasa Efectiva Mensual (TEM)\n" +
                        "Tasa Efectiva Quincenal (TEQ)\n" +
                        "Tasa Efectiva Diaria (TED)\n" +
                        "Tipo de Tasa Efectiva: ");
                te = scanner.nextLine();
            }

            scanner2.close();
            */
        	String te = data.tipoTasaEfectiva;

            if (te.equalsIgnoreCase("TES")) {
                this.plan.setTEA(Math.pow(1 + vte, 2) - 1);
            } else if (te.equalsIgnoreCase("TEC")) {
                this.plan.setTEA(Math.pow(1 + vte, 3) - 1);
            } else if (te.equalsIgnoreCase("TET")) {
                this.plan.setTEA(Math.pow(1 + vte, 4) - 1);
            } else if (te.equalsIgnoreCase("TEB")) {
                this.plan.setTEA(Math.pow(1 + vte, 6) - 1);
            } else if (te.equalsIgnoreCase("TEM")) {
                this.plan.setTEA(Math.pow(1 + vte, 12) - 1);
            } else if (te.equalsIgnoreCase("TEQ")) {
                this.plan.setTEA(Math.pow(1 + vte, 24) - 1);
            } else if (te.equalsIgnoreCase("TED")) {
                this.plan.setTEA(Math.pow(1 + vte, 360) - 1);
            } else {
                this.plan.setTEA(vte);
            }

        } else{
            // Scanner scanner3 = new Scanner(System.in);
            double vtn = 0.0;
            vtn = data.valorTasaNominal; // Valor de la tasa nominal
            try {
                if (vtn < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\nError: El valor de la tasa nominal debe ser un número mayor o igual a cero con o sin decimales.\n");
            }

            /* ENTRADA DE USUARIO -----------> Valor de la tasa nominal
            while (true) {
                System.out.print("Ingrese el valor de la tasa nominal dividida entre 100: ");
                vtn = scanner3.nextDouble(); // Valor de la tasa nominal

                try {
                    if (vtn < 0) {
                        throw new IllegalArgumentException();
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("\nError: El valor de la tasa nominal debe ser un número mayor o igual a cero con o sin decimales.\n");
                }
            }
            */

            String tn;

            /*while (true) { // ENTRADA USUARIO tipo de Tasa Nominal
                System.out.print("Ingrese el tipo de Tasa Nominal:\n"
                        + "Tasa Nominal Anual (TNA)\n"
                        + "Tasa Nominal Semestral (TNS)\n"
                        + "Tasa Nominal Cuatrimestral (TNC)\n"
                        + "Tasa Nominal Trimestral (TNT)\n"
                        + "Tasa Nominal Bimestral (TNB)\n"
                        + "Tasa Nominal Mensual (TNM)\n"
                        + "Tasa Nominal Quincenal (TNQ)\n"
                        + "Tasa Nominal Diaria (TND)\n"
                        + "Tipo de Tasa Nominal: ");
                tn = scanner3.next();

                if (tn.equalsIgnoreCase("TNA") || tn.equalsIgnoreCase("TNS") || tn.equalsIgnoreCase("TNC")
                        || tn.equalsIgnoreCase("TNT") || tn.equalsIgnoreCase("TNB") || tn.equalsIgnoreCase("TNM")
                        || tn.equalsIgnoreCase("TNQ") || tn.equalsIgnoreCase("TND")) {
                    break;
                } else {
                    System.out.println("\nIngrese correctamente el tipo de Tasa Nominal:\n"
                            + "Tasa Nominal Anual (TNA)\n"
                            + "Tasa Nominal Semestral (TNS)\n"
                            + "Tasa Nominal Cuatrimestral (TNC)\n"
                            + "Tasa Nominal Trimestral (TNT)\n"
                            + "Tasa Nominal Bimestral (TNB)\n"
                            + "Tasa Nominal Mensual (TNM)\n"
                            + "Tasa Nominal Quincenal (TNQ)\n"
                            + "Tasa Nominal Diaria (TND)\n"
                            + "Tipo de Tasa Nominal: ");
                }
            }
      

            scanner3.close();
            */
            
            tn = data.tipoTasaNominal;
            // aScanner scanner4 = new Scanner(System.in);
            int cap = 0;
            cap = data.frecuenciaCapitalizacionDias; // Frecuencia de capitalización en días
            try {
                if (cap < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\nError: La frecuencia de capitalización de la tasa nominal debe ser un número entero mayor que 0.\n");
            }

            /* ENTRADA USUARIO frecuencia de la capitalización en días
            while (true) {
                System.out.print("Ingrese la frecuencia de la capitalización en días: ");
                cap = scanner.nextInt(); // Frecuencia de capitalización en días

                try {
                    if (cap < 0) {
                        throw new IllegalArgumentException();
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("\nError: La frecuencia de capitalización de la tasa nominal debe ser un número entero mayor que 0.\n");
                }
            }*/

            double tna = 0.0;

            int m = 360 / cap; // Número de periodos de capitalización

            if (tn.toUpperCase().equals("TNS")) {
                tna = vtn * 2; // Tasa nominal anual
            } else if (tn.toUpperCase().equals("TNC")) {
                tna = vtn * 3; // Tasa nominal anual
            } else if (tn.toUpperCase().equals("TNT")) {
                tna = vtn * 4; // Tasa nominal anual
            } else if (tn.toUpperCase().equals("TNB")) {
                tna = vtn * 6; // Tasa nominal anual
            } else if (tn.toUpperCase().equals("TNM")) {
                tna = vtn * 12; // Tasa nominal anual
            } else if (tn.toUpperCase().equals("TNQ")) {
                tna = vtn * 24; // Tasa nominal anual
            } else if (tn.toUpperCase().equals("TND")) {
                tna = vtn * 360; // Tasa nominal anual
            } else {
                tna = vtn * 1; // Tasa nominal anual
            }

            this.plan.setTEA(Math.pow(1 + tna / m, m) - 1);
            // scanner4.close();
        }

        // Scanner scanner5 = new Scanner(System.in);

        // Ingresar y validar Precio de venta PV
        /*
        while (true) {
            String pvInput = scanner5.nextLine();
            try {
                double pv = Double.parseDouble(pvInput); DATOS DE ENTRADA
                if (pv < 1) {
                    throw new IllegalArgumentException();
                }
                this.plan.setPV(pv);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nError: El precio de venta debe ser un número con decimales mayor que 0.\n");
            }
        }
        scanner5.close();
        */
        try {
        	double pv = data.precioVenta;
            if (pv < 1) {
                throw new IllegalArgumentException();
            }
            this.plan.setPV(pv);
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: El precio de venta debe ser un número con decimales mayor que 0.\n");
        }
                
        /*
         * Scanner scanner6 = new Scanner(System.in);
        // Ingresar y validar Porcentaje de cuota inicial pCI
        while (true) {
            String pciInput = scanner6.nextLine(); DATOS DE ENTRADA
            try {
                double pci = Double.parseDouble(pciInput);
                if (pci < 0) {
                    throw new IllegalArgumentException();
                }
                this.plan.setPCI(pci);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nError: El porcentaje de la cuota inicial debe ser un número con o sin decimales mayor o igual que 0.\n");
            }
        }
        scanner6.close();
        */
        
        try {
        	double pci = data.porcentajeCuotaInicial;
            if (pci < 0) {
                throw new IllegalArgumentException();
            }
            this.plan.setPCI(pci);
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: El porcentaje de la cuota inicial debe ser un número con o sin decimales mayor o igual que 0.\n");
        }

        // Scanner scanner7 = new Scanner(System.in);

        // Ingresar y validar Numero de anios NA DATOS DE ENTRADA
        /*
        while (true) {
            String naInput = scanner7.nextLine();
            try {
                int na = Integer.parseInt(naInput);
                if (na < 1) {
                    throw new IllegalArgumentException();
                }
                this.plan.setNA(na);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nError: El número de años debe ser un número entero mayor que 0.\n");
            }
        }
        scanner7.close();
        */
        
        try {
        	int na = data.numeroAnios;
            if (na < 1) {
                throw new IllegalArgumentException();
            }
            this.plan.setNA(na);
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: El número de años debe ser un número entero mayor que 0.\n");
        }
        
        /*
        Scanner scanner8 = new Scanner(System.in);

        // Ingresar y validar el tipo de periodo de gracia
        String pgInput = scanner8.nextLine();

        while (!pgInput.equalsIgnoreCase("T") && !pgInput.equalsIgnoreCase("P") && !pgInput.equalsIgnoreCase("N")) {
            pgInput = scanner8.nextLine(); // DATOS ENTRADA
        }

        this.plan.setPG(pgInput.toUpperCase());
        scanner8.close();
        */

        // Scanner scanner9 = new Scanner(System.in);

        String pgInput = data.tipoPeriodoGracia;
        this.plan.setPG(pgInput.toUpperCase());
        
        
        this.plan.setNPG(0);        
        if (!this.plan.getPG().equals("N")) {
        	try {
        		int npg = data.cantidadPeriodoGracia;
                if (npg < 1) {
                    throw new IllegalArgumentException();
                }
                this.plan.setNPG(npg);
            } catch (IllegalArgumentException e) {
                System.out.println("\nError: La cantidad de periodos del periodo de gracia debe ser un número entero mayor que 0.\n");
            }
        }
        /*
        if (!this.plan.getPG().equals("N")) {
            while (true) {
                String npgInput = scanner9.nextLine();
                try {
                    int npg = Integer.parseInt(npgInput); DATOS DE ENTRADA
                    if (npg < 1) {
                        throw new IllegalArgumentException();
                    }
                    this.plan.setNPG(npg);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("\nError: La cantidad de periodos del periodo de gracia debe ser un número entero mayor que 0.\n");
                }
            }
        }
        scanner9.close();
        */

        
        /*
        Scanner scanner10 = new Scanner(System.in);

        while (true) {
            String tsdInput = scanner10.nextLine();
            try {
                double tsd = Double.parseDouble(tsdInput); DATOS DE ENTRADA
                if (tsd < 0) {
                    throw new IllegalArgumentException();
                }
                this.plan.setTSD(tsd);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nError: La tasa del seguro de desgravamen debe ser un número mayor o igual a cero.\n");
            }
        }
        scanner10.close();
        */
        
        try {
        	double tsd = data.tasaSeguroDesgravamen;
            if (tsd < 0) {
                throw new IllegalArgumentException();
            }
            this.plan.setTSD(tsd);
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: La tasa del seguro de desgravamen debe ser un número mayor o igual a cero.\n");
        }

        /*
        Scanner scanner11 = new Scanner(System.in);

        while (true) {
            String tsrInput = scanner11.nextLine();
            try {
                double tsr = Double.parseDouble(tsrInput); // DATOS DE ENTRADA
                if (tsr < 0) {
                    throw new IllegalArgumentException();
                }
                this.plan.setTSR(tsr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nError: La tasa del seguro contra todo riesgo debe ser un número mayor o igual a cero.\n");
            }
        }
        scanner11.close();
        */
        
        try {
        	double tsr = data.tasaSeguroTodoRiesgo;
            if (tsr < 0) {
                throw new IllegalArgumentException();
            }
            this.plan.setTSR(tsr);
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: La tasa del seguro contra todo riesgo debe ser un número mayor o igual a cero.\n");
        }

        /*
        Scanner scanner12 = new Scanner(System.in);

        while (true) {
            String gaInput = scanner12.nextLine();
            try {
                double ga = Double.parseDouble(gaInput); // DATOS ENTRADA
                if (ga < 0) {
                    throw new IllegalArgumentException();
                }
                this.plan.setGA(ga);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nError: Los gastos administrativos deben ser un número mayor o igual a cero.\n");
            }
        }
        scanner12.close();
        */

        
        try {
        	double ga = data.gastosAdministrativos;
            if (ga < 0) {
                throw new IllegalArgumentException();
            }
            this.plan.setGA(ga);
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: Los gastos administrativos deben ser un número mayor o igual a cero.\n");
        }
        /*
        Scanner scanner13 = new Scanner(System.in);

        while (true) {
            String pInput = scanner13.nextLine();
            try {
                double p = Double.parseDouble(pInput); // DATOS ENTRADA
                if (p < 0) {
                    throw new IllegalArgumentException();
                }
                this.plan.setP(p);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nError: Los portes deben ser un número mayor o igual a cero.\n");
            }
        }
        scanner13.close();
        */

        
        try {
        	double p = data.portes;
            if (p < 0) {
                throw new IllegalArgumentException();
            }
            this.plan.setP(p);
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: Los portes deben ser un número mayor o igual a cero.\n");
        }
        /*
        Scanner scanner14 = new Scanner(System.in);

        while (true) {
            String cpInput = scanner14.nextLine();
            try {
                double cp = Double.parseDouble(cpInput); // DATOS ENTRADA
                if (cp < 0) {
                    throw new IllegalArgumentException();
                }
                this.plan.setCP(cp);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nError: La comisión periódica debe ser un número mayor o igual a cero.\n");
            }
        }
        scanner14.close();
        */
        
        
        try {
        	double cp = data.comisionPeriodica;
            if (cp < 0) {
                throw new IllegalArgumentException();
            }
            this.plan.setCP(cp);
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: La comisión periódica debe ser un número mayor o igual a cero.\n");
        }

        /*
        Scanner scanner15 = new Scanner(System.in);

        while (true) {
            String cnInput = scanner15.nextLine();
            try {
                double cn = Double.parseDouble(cnInput); //DATOS ENTRADA
                if (cn < 0) {
                    throw new IllegalArgumentException();
                }
                this.plan.setCN(cn);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nError: Los costos notariales deben ser un número mayor o igual a cero.\n");
            }
        }
        scanner15.close();
        */
        
        try {
            double cn = data.costosNotariales; //DATOS ENTRADA
            if (cn < 0) {
                throw new IllegalArgumentException();
            }
            this.plan.setCN(cn);
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: Los costos notariales deben ser un número mayor o igual a cero.\n");
        }

        /*
        Scanner scanner16 = new Scanner(System.in);

        while (true) {
            String crInput = scanner16.nextLine();
            try {
                double cr = Double.parseDouble(crInput); // DATOS ENTRADA
                if (cr < 0) {
                    throw new IllegalArgumentException();
                }
                this.plan.setCR(cr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nError: Los costos registrales deben ser un número mayor o igual a cero.\n");
            }
        }
        scanner16.close();
        */
        try {
            double cr = data.registrales; // DATOS ENTRADA
            if (cr < 0) {
                throw new IllegalArgumentException();
            }
            this.plan.setCR(cr);
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: Los costos registrales deben ser un número mayor o igual a cero.\n");
        }

        //------------------A PARTIR DE AQUI SE PROCESAN LOS DATOS INTERMEDIOS------------------

        // Calcular cuota inicial (en número, ya no en porcentaje) CI
        this.plan.setCI(this.plan.getPCI() * this.plan.getPV());

        // Calcular préstamo C
        this.plan.setC(this.plan.getPV() - this.plan.getCI() + this.plan.getCN() + this.plan.getCR()); // Los costos notariales y registrales se adjudican al monto del préstamo
        this.plan.setAUX3(this.plan.getC());

        // Calcular número total de cuotas
        this.plan.setN(this.plan.getNCxA() * this.plan.getNA());

        // Inicialización del periodo actual
        this.plan.setNC(1);

        // Inicialización del saldo final
        this.plan.setSF(0);

        // Inicialización de la cuota total
        this.plan.setRT(0);

        // Inicialización de la amortización total
        this.plan.setAT(0);

        // Inicialización del número de veces que se ha repetido el plan de pagos
        this.plan.setVueltas(0);

        // Inicialización de la tasa del periodo (la tasa será mensual)
        // this.plan.setTEP(Math.pow(1 + this.plan.getTEA(), 1 / 12) - 1);
        this.plan.setTEP(Math.pow((1.0 + 1.5181701168189803), (1.0 / 12.0)) - 1.0);

        // Cálculo de la tasa de seguro de desgravamen anual
        this.plan.setTSDA(this.plan.getTSD() * 12);

        // Cálculo de la Tasa de Seguro de Desgravamen Ajustada al Plazo
        this.plan.setTSDP(this.plan.getTSDA() / 360 * 30);

        // Cálculo de la tasa de seguro contra todo riesgo anual
        this.plan.setTSRA(this.plan.getTSR() * 12);

        // Cálculo de la Tasa de Seguro Contra Todo Riesgo Ajustada al Plazo
        this.plan.setTSRP(this.plan.getTSRA() / 360 * 30);

        //------------------A PARTIR DE AQUI SE CALCULA EL PLAN DE PAGOS------------------

        this.PDP();

        System.out.println(this.plan.getVPSF());
        System.out.println(this.plan.getR2());

    }

    public void imprimirInformacion() {
        System.out.println("\nNumero de dias por anio: " + this.plan.getNDxA());
        System.out.println("Precio de venta del bien: " + this.plan.getPV());
        System.out.println("Porcentaje de la cuota inicial: " + String.format("%.7f", this.plan.getPCI() * 100) + "%");
        System.out.println("Frecuencia de pago: " + this.plan.getFrec() + " dias");
        System.out.println("Numero de anios: " + this.plan.getNA());
        System.out.println("Cuota inicial: " + String.format("%.2f", this.plan.getCI()));
        System.out.println("Prestamo: " + String.format("%.2f", this.plan.getC()));
        System.out.println("Numero de cuotas por anio: " + this.plan.getNCxA());
        System.out.println("Numero total de cuotas: " + this.plan.getN());
        System.out.println("Tasa Efectiva Anual: " + String.format("%.7f", this.plan.getTEA() * 100) + "%");
        System.out.println("Tipo de periodo de gracia: " + this.plan.getPG());
        System.out.println("Cantidad de periodos del periodo de gracia: " + this.plan.getNPG());
        System.out.println("Amortizacion total: " + String.format("%.2f", this.plan.getAT()));
        System.out.println("Gastos administrativos: " + this.plan.getGA());
        System.out.println("Portes: " + this.plan.getP());
        System.out.println("Costos notariales: " + this.plan.getCN());
        System.out.println("Costos registrales: " + this.plan.getCR());
        System.out.println("TSD: " + String.format("%.7f", this.plan.getTSD() * 100) + "%");
        System.out.println("Seguro de desgravamen: " + String.format("%.2f", this.plan.getSD()));
        System.out.println("Seguro contra todo riesgo: " + String.format("%.2f", this.plan.getSR()));
    }


}
