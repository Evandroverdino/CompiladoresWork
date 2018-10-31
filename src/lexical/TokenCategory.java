package lexical;

public enum TokenCategory {

	tID(1), tEMPTY(2), tINT(3), tFLOAT(4), tCHAR(5), tSTRING(6), tBOOL(7), tMODULE(8), tFUN(9), tRETURN(10), tMAIN(11),
	tREAD(12), tSHOW(13), tIF(14), tELIF(15), tELSE(16), tWHEN(17), tREPEATER(18), tTRUE(19), tFALSE(20), tCTEINT(21),
	tCTEFLOAT(22), tCTECHAR(23), tCTESTRING(24), tSPTR(25), tCO(26), tSCO(27), tOK(28), tCK(29), tOP(30), tCP(31),
	tOB(32), tCB(33), tOPA(34), tOPM(35), tOPE(36), tOPU(37), tATR(38), tORC(39), tORE(40), tAND(41), tOR(42), tNOT(43),
	tCONCAT(44), tNULL(45), tCOMMENT(46);

	private int value;

	private TokenCategory(int value) {
		this.value = value;
	}

	public int getCategoryValue() {
		return value;
	}
}