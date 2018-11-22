package lexical;

public enum TokenCategory {

	tMAIN(1),
	tID(2), 
	tEMPTY(3), 
	tINT(4),
	tBOOL(6),
	tCHAR(7), 
	tSTRING(8),
	tFLOAT(9),
	tOK(10), 
	tCK(11),
	tOP(12), 
	tCP(13),
	tOB(14), 
	tCB(15),
	tCOMMENT(16),
	tSCO(17),
	tSPTR(18),
	tCTEINT(20),
	tCTEFLOAT(21), 
	tCTEBOOL(22), 
	tCTECHAR(23), 
	tCTESTRING(24),
	tIF(25),  
	tELSE(26),
	tELIF(27),
	tREPEATER(28),
	tWHEN(30),
	tSHOW(31), 
	tREAD(32), 
	tRETURN(33),
	tAND(34), 
	tOR(35),
	tNOT(36),
	tOPA(37), 
	tOPM(38), 
	tOPE(39),
	tOPU(40), 
	tORC(41), 
	tORE(42), 	
	tATR(43), 
	tCONCAT(44),	 
	tNULL(45);	

	private int value;
	
	private TokenCategory(int value) {
		this.value = value;
	}

	public int getCategoryValue() {
		return value;
	}
	
}