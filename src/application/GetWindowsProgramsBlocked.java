package application;

import static com.sun.jna.platform.win32.WinReg.HKEY_LOCAL_MACHINE;
import com.sun.jna.platform.win32.Advapi32Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import static com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER;
import static com.sun.jna.platform.win32.WinReg.HKEY_LOCAL_MACHINE;

@SuppressWarnings("unused")
public class GetWindowsProgramsBlocked {
	public GetWindowsProgramsBlocked(int flag) throws IndexOutOfBoundsException {
		ManipuladorDeArquivo arquivo = new ManipuladorDeArquivo();

		// Define o path padrao
		String username = System.getProperty("user.name");
		// System.out.println(username);
		String path = "C:\\Users\\" + username + "\\AppData\\Local\\Run Blocker\\";
		String nomeDoArquivo = "ProgramsBlocked.txt";

		switch (flag) {
		case 0:
			try {
				arquivo.leitor(path, nomeDoArquivo); // Cria o arquivo e salva os dados
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Error when opening the locked programs file!\nError: " + e1);
			}
			break;

		case 1:
			try {
				arquivo.escritor(path, nomeDoArquivo, InterfaceJframe.fileNameB, InterfaceJframe.filePathB); // Cria o arquivo e salva os dados
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Error when opening the locked programs file!\nError: " + e1);
			}
			break;
		default:

		}
	}
}
