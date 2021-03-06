package hw1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class HW1 {
	@SuppressWarnings("serial")
	static void Problem_1() {
		String cipherText = "JDTTZBVJS!EBUEZXBSEHTSS JTEBSEMTBVJEDT N,EZXTVEGAVJD ZCW ZBAVS,ELACDED GTEBSE EG VNBN ZTEBVEOABVBVJEZXTESZTWWTDEZDBMCV WECVBUBTNEQTAQWTSEBVZTWWBJTVGTENBIBSBAV,E WSAEPVAKVE SESZCQBN.ESZCQBNEBSE VEBVZTDSZTWW DEJDACQEH NTECQEAUEZXTECVBITDST'SEHASZEBVZTWWBJTVZEWBUTEUADHS.EKTEX ITECZHASZE CZXADBZLEBVE WWEH ZZTDSEAUEZD ITWE VNENBQWAH GL,ESAEOABVBVJEKACWNEMTEAUEMTSZEBVZTDTSZEUADELACDED GT.ELACEX ITEMTTVEDTGTBIBVJEZXTSTEHTSS JTSE SEZTSZSEZAEJ CJTELACDESQTGBTS'EBVZTWWBJTVGT.EZKAEHADTEZTSZSEW LEMTUADTELAC,EKXBGXELACEKBWWEVTTNEZAEQ SSEZAEDTGTBITETVZD VGT.ECQAVEQ SSBVJE WWEQDTWBHBV DBTS,E WWEWBUTUADHSE DTEKTWGAHTEBVZAEACDECVBAV,ETITVEBVZTWWBJTVZEJ S-M STNEGWCSZTDSEX ITE EXAHTEXTDT.E GZC WWL,EZXTDTEBSEAVTETFGTQZBAV:EVAEHT Z-M STNEWBUTUADHSE WWAKTN,EZX ZEKACWNEOCSZEMTEV SZL.EMCZEKXAE DTEKTEPBNNBVJ,EBZ'SEBHQASSBMWTEZAEX ITEBVZTWWBJTVZEHT Z-M STNEWBUT.EBEHT VEG VELACEBH JBVTEZ WPBVJEHT Z?E VLK L,ECVWTSSELAC'DTEHT Z,EKTEKBSXELACEWCGPEKBZXELACDEUCDZXTDEZTSZS.E( VNEBUELACETITDEJTZESZCGP,EDTHTHMTDEZX ZELACEG VE SPEYCTSZBAVSEAVEQB RR )";
		HashMap<Character, Integer> frequencies = new HashMap<Character, Integer>();
		// BEGIN SOLUTION
                int cipLength = cipherText.length();
                char cCounter = 'A';
                int i;
                int j;
                double totalFreq;
                
                for(i = 1; i <= 27; i++)  
                {
                    int freq = 0;
                    for(j = 0; j < cipLength-1; j++)
                    {
                        
                        if(cipherText.charAt(j) == cCounter)
                           freq++;
                        
                    }
                    totalFreq = (double)freq / cipLength;
   
                      frequencies.put(cCounter, freq);
                    System.out.println("'" + cCounter + "' = " + totalFreq);
                    if(i < 26)
                        cCounter++;
                    else
                        cCounter = ' ';
                    
                }
                
    
		HashMap<Character, Character> key = new HashMap<Character, Character>() {
			{
				put('A', 'O');
				put('B', 'I');
				put('C', 'U');
				put('D', 'R');
				put('E', ' ');
				put('F', 'X');
				put('G', 'C');
				put('H', 'M');
				put('I', 'V');
				put('J', 'G');
				put('K', 'W');
				put('L', 'Y');
				put('M', 'B');
				put('N', 'D');
				put('O', 'J');
				put('P', 'K');
				put('Q', 'P');
				put('R', 'Z');
				put('S', 'S');
				put('T', 'E');
				put('U', 'F');
				put('V', 'N');
				put('W', 'L');
				put('X', 'H');
				put('Y', 'Q');
				put('Z', 'T');
				put(' ', 'A');
			}
		};
		for (char c : cipherText.toCharArray()) {
			if (key.containsKey(c))
				System.out.print(key.get(c));
			else
				System.out.print(c);
		}
                System.out.println("");
		// END SOLUTION
	}

	static void Problem_2() throws IOException {
		byte[] cipherText1 = Files.readAllBytes(Paths.get("cipher1.txt"));
		byte[] cipherText2 = Files.readAllBytes(Paths.get("cipher2.txt"));
		// BEGIN SOLUTION
		String plainText1 = "GREETINGS! IF THIS MESSAGE IS BEING READ, THEN CONGRATULATIONS, YOUR RACE IS A CANDIDATE IN JOINING THE STELLER TRIBUNAL UNIFIED PEOPLES INTELLIGENCE DIVISION, ALSO KNOWN AS STUPID. STUPID IS AN INTERSTELLAR GROUP MADE UP OF THE UNIVERSE'S MOST INTELLIGENT LIFE FORMS. WE HAVE UTMOST AUTHORITY IN ALL MATTERS OF TRAVEL AND DIPLOMACY, SO JOINING WOULD BE OF BEST INTEREST FOR YOUR RACE. YOU HAVE BEEN RECEIVING THESE MESSAGES AS TESTS TO GAUGE YOUR SPECIES' INTELLIGENCE. TWO MORE TESTS LAY BEFORE YOU, WHICH YOU WILL NEED TO PASS TO RECEIVE ENTRANCE. UPON PASSING ALL PRELIMINARIES, ALL LIFEFORMS ARE WELCOME INTO OUR UNION, EVEN INTELLIGENT GAS-BASED CLUSTERS HAVE A HOME HERE. ACTUALLY, THERE IS ONE EXCEPTION: NO MEAT-BASED LIFEFORMS ALLOWED, THAT WOULD JUST BE NASTY. BUT WHO ARE WE KIDDING, IT'S IMPOSSIBLE TO HAVE INTELLIGENT MEAT-BASED LIFE. I MEAN CAN YOU IMAGINE TALKING MEAT? ANYWAY, UNLESS YOU'RE MEAT, WE WISH YOU LUCK WITH YOUR FURTHER TESTS. (AND IF YOU EVER GET STUCK, REMEMBER THAT YOU CAN ASK QUESTIONS ON PIAZZA)                                                                                                                                                                                                                                                                                                                                                                                                                   ";               
		byte[] plainText1bytes = plainText1.getBytes();
                byte[] key = new byte[plainText1bytes.length];
                
                for(int i = 0; i < cipherText1.length; i++)
                {
                    key[i] = (byte)(cipherText1[i] ^ plainText1bytes[i]);
                }
                
		// Here be dragons ...
		byte[] plainText2bytes = new byte[cipherText2.length];
                for(int i = 0; i < cipherText2.length; i++)
                    plainText2bytes[i] = (byte)(cipherText2[i] ^ key[i]);
		String plainText2 = new String(plainText2bytes);
		// END SOLUTION
		System.out.println(plainText2);
	}

	static void Problem_3() throws IOException {
		byte[] cipherText = Files.readAllBytes(Paths.get("cipher3.bmp"));
		byte[] plainText = new byte[cipherText.length];
		// BEGIN SOLUTION
                byte[] key = new byte[2];
                
		// Magic happens here!

                    key[0] = (byte)(cipherText[0] ^ 66);
                
                for(int i = 1; i < key.length; i+=2)
                    key[1] = (byte)(cipherText[1] ^ 77);
                for(int i = 0; i < cipherText.length ; i++)
                {
                if(i % 2 == 0)
                    plainText[i] = (byte)(cipherText[i] ^ key[0]);
                else
                    plainText[i] = (byte)(cipherText[i] ^ key[1]);
                }
		// END SOLUTION
		Files.write(Paths.get("plain.bmp"), plainText);
	}

	public static void main(String[] args) throws IOException {
		Problem_1();
		Problem_2();
		Problem_3();
	}
}
