import Instructions.MIPSInstructionManager;
import Instructions.MIPSand;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Disassembles valid 8-digit hexadecimal code into relevant MIPS instruction values.");
            System.out.println("Usage: java -jar PROG2_Milestone1.jar <hexCode>");
            System.out.println("Test: java -jar PROG2_Milestone1.jar test");
            System.exit(1);
        }

        String input = args[0];

        if (input.equalsIgnoreCase("test")) {
            testToString();
        } else {
            if (input.matches("^[0-9A-Fa-f]{8}$")) {
                disassemble(input);
            } else {
                System.err.println("Error: Invalid hex code. Please provide an 8-digit hexadecimal code.");
                System.exit(1);
            }
        }
    }

    public static String disassemble(String hexString) {
        long hexCode = Long.parseLong(hexString, 16);
        return MIPSInstructionManager.toString((int) hexCode);
    }

    public static void testToString() {
        for (int i = 0; i < testCodes.length; ++i) {
            System.out.print(testCodes[i] + ":");
            String output = disassemble(testCodes[i]);
            if (!output.equals(expectedOutput[i])) {
                System.out.println("Test Failed");
            } else {
                System.out.println(" ");
            }
            System.out.println("Evaluated:\t" + output);
            System.out.println("Expected:\t" + expectedOutput[i]);
            System.out.println(" ");
        }
    }

    static String[] testCodes = {
            "020ed020",
            "004a2820",
            "0269f820",
            "02fc3020",
            "030ae020",
            "246600e0",
            "240c004c",
            "27fd008c",
            "27180035",
            "2743006a",
            "03116024",
            "012c4824",
            "03203824",
            "00d30024",
            "01df4824",
            "3279ff12",
            "33b6008d",
            "3342ff88",
            "32150049",
            "30f9ffda",
            "11190030",
            "115cff48",
            "116cffb5",
            "134fff21",
            "11c0ff87",
            "1725001d",
            "16730038",
            "1523ffa4",
            "143fff38",
            "17f000ea",
            "080000fa",
            "080000c7",
            "080000b3",
            "080000ac",
            "08000011",
            "3c050016",
            "3c1f002a",
            "3c0b0010",
            "3c090080",
            "3c140013",
            "8de00000",
            "8f6600c8",
            "8c2700f9",
            "8dcb0000",
            "8eadff72",
            "0141b025",
            "03378825",
            "025e2025",
            "03c4a825",
            "01592025",
            "36d2008d",
            "35c200c5",
            "37c3fffb",
            "35a50087",
            "34f7ff84",
            "005ae82a",
            "0375282a",
            "00f2402a",
            "03ad202a",
            "020ab02a",
            "01623022",
            "01c8e822",
            "02063822",
            "03dad022",
            "00d4e022",
            "afcb0000",
            "afa30000",
            "af370000",
            "aef5ff3a",
            "af610000",
            "0000000c",
            "0000000c",
            "0000000c",
            "0000000c",
            "0000000c"
    };

    static String[] expectedOutput = {
            "add {opcode: 00, rs: 10, rt: 0e, rd: 1a, shmt: 00, funct: 20}",
            "add {opcode: 00, rs: 02, rt: 0a, rd: 05, shmt: 00, funct: 20}",
            "add {opcode: 00, rs: 13, rt: 09, rd: 1f, shmt: 00, funct: 20}",
            "add {opcode: 00, rs: 17, rt: 1c, rd: 06, shmt: 00, funct: 20}",
            "add {opcode: 00, rs: 18, rt: 0a, rd: 1c, shmt: 00, funct: 20}",
            "addiu {opcode: 09, rs(base): 03, rt: 06, immediate(offset): 00e0}",
            "addiu {opcode: 09, rs(base): 00, rt: 0c, immediate(offset): 004c}",
            "addiu {opcode: 09, rs(base): 1f, rt: 1d, immediate(offset): 008c}",
            "addiu {opcode: 09, rs(base): 18, rt: 18, immediate(offset): 0035}",
            "addiu {opcode: 09, rs(base): 1a, rt: 03, immediate(offset): 006a}",
            "and {opcode: 00, rs: 18, rt: 11, rd: 0c, shmt: 00, funct: 24}",
            "and {opcode: 00, rs: 09, rt: 0c, rd: 09, shmt: 00, funct: 24}",
            "and {opcode: 00, rs: 19, rt: 00, rd: 07, shmt: 00, funct: 24}",
            "and {opcode: 00, rs: 06, rt: 13, rd: 00, shmt: 00, funct: 24}",
            "and {opcode: 00, rs: 0e, rt: 1f, rd: 09, shmt: 00, funct: 24}",
            "andi {opcode: 0c, rs(base): 13, rt: 19, immediate(offset): ff12}",
            "andi {opcode: 0c, rs(base): 1d, rt: 16, immediate(offset): 008d}",
            "andi {opcode: 0c, rs(base): 1a, rt: 02, immediate(offset): ff88}",
            "andi {opcode: 0c, rs(base): 10, rt: 15, immediate(offset): 0049}",
            "andi {opcode: 0c, rs(base): 07, rt: 19, immediate(offset): ffda}",
            "beq {opcode: 04, rs(base): 08, rt: 19, immediate(offset): 0030}",
            "beq {opcode: 04, rs(base): 0a, rt: 1c, immediate(offset): ff48}",
            "beq {opcode: 04, rs(base): 0b, rt: 0c, immediate(offset): ffb5}",
            "beq {opcode: 04, rs(base): 1a, rt: 0f, immediate(offset): ff21}",
            "beq {opcode: 04, rs(base): 0e, rt: 00, immediate(offset): ff87}",
            "bne {opcode: 05, rs(base): 19, rt: 05, immediate(offset): 001d}",
            "bne {opcode: 05, rs(base): 13, rt: 13, immediate(offset): 0038}",
            "bne {opcode: 05, rs(base): 09, rt: 03, immediate(offset): ffa4}",
            "bne {opcode: 05, rs(base): 01, rt: 1f, immediate(offset): ff38}",
            "bne {opcode: 05, rs(base): 1f, rt: 10, immediate(offset): 00ea}",
            "j {opcode: 02, index: 00000fa}",
            "j {opcode: 02, index: 00000c7}",
            "j {opcode: 02, index: 00000b3}",
            "j {opcode: 02, index: 00000ac}",
            "j {opcode: 02, index: 0000011}",
            "lui {opcode: 0f, rs(base): 00, rt: 05, immediate(offset): 0016}",
            "lui {opcode: 0f, rs(base): 00, rt: 1f, immediate(offset): 002a}",
            "lui {opcode: 0f, rs(base): 00, rt: 0b, immediate(offset): 0010}",
            "lui {opcode: 0f, rs(base): 00, rt: 09, immediate(offset): 0080}",
            "lui {opcode: 0f, rs(base): 00, rt: 14, immediate(offset): 0013}",
            "lw {opcode: 23, rs(base): 0f, rt: 00, immediate(offset): 0000}",
            "lw {opcode: 23, rs(base): 1b, rt: 06, immediate(offset): 00c8}",
            "lw {opcode: 23, rs(base): 01, rt: 07, immediate(offset): 00f9}",
            "lw {opcode: 23, rs(base): 0e, rt: 0b, immediate(offset): 0000}",
            "lw {opcode: 23, rs(base): 15, rt: 0d, immediate(offset): ff72}",
            "or {opcode: 00, rs: 0a, rt: 01, rd: 16, shmt: 00, funct: 25}",
            "or {opcode: 00, rs: 19, rt: 17, rd: 11, shmt: 00, funct: 25}",
            "or {opcode: 00, rs: 12, rt: 1e, rd: 04, shmt: 00, funct: 25}",
            "or {opcode: 00, rs: 1e, rt: 04, rd: 15, shmt: 00, funct: 25}",
            "or {opcode: 00, rs: 0a, rt: 19, rd: 04, shmt: 00, funct: 25}",
            "ori {opcode: 0d, rs(base): 16, rt: 12, immediate(offset): 008d}",
            "ori {opcode: 0d, rs(base): 0e, rt: 02, immediate(offset): 00c5}",
            "ori {opcode: 0d, rs(base): 1e, rt: 03, immediate(offset): fffb}",
            "ori {opcode: 0d, rs(base): 0d, rt: 05, immediate(offset): 0087}",
            "ori {opcode: 0d, rs(base): 07, rt: 17, immediate(offset): ff84}",
            "slt {opcode: 00, rs: 02, rt: 1a, rd: 1d, shmt: 00, funct: 2a}",
            "slt {opcode: 00, rs: 1b, rt: 15, rd: 05, shmt: 00, funct: 2a}",
            "slt {opcode: 00, rs: 07, rt: 12, rd: 08, shmt: 00, funct: 2a}",
            "slt {opcode: 00, rs: 1d, rt: 0d, rd: 04, shmt: 00, funct: 2a}",
            "slt {opcode: 00, rs: 10, rt: 0a, rd: 16, shmt: 00, funct: 2a}",
            "sub {opcode: 00, rs: 0b, rt: 02, rd: 06, shmt: 00, funct: 22}",
            "sub {opcode: 00, rs: 0e, rt: 08, rd: 1d, shmt: 00, funct: 22}",
            "sub {opcode: 00, rs: 10, rt: 06, rd: 07, shmt: 00, funct: 22}",
            "sub {opcode: 00, rs: 1e, rt: 1a, rd: 1a, shmt: 00, funct: 22}",
            "sub {opcode: 00, rs: 06, rt: 14, rd: 1c, shmt: 00, funct: 22}",
            "sw {opcode: 2b, rs(base): 1e, rt: 0b, immediate(offset): 0000}",
            "sw {opcode: 2b, rs(base): 1d, rt: 03, immediate(offset): 0000}",
            "sw {opcode: 2b, rs(base): 19, rt: 17, immediate(offset): 0000}",
            "sw {opcode: 2b, rs(base): 17, rt: 15, immediate(offset): ff3a}",
            "sw {opcode: 2b, rs(base): 1b, rt: 01, immediate(offset): 0000}",
            "syscall {opcode: 00, code: 000000, funct: 0c}",
            "syscall {opcode: 00, code: 000000, funct: 0c}",
            "syscall {opcode: 00, code: 000000, funct: 0c}",
            "syscall {opcode: 00, code: 000000, funct: 0c}",
            "syscall {opcode: 00, code: 000000, funct: 0c}"
    };

}