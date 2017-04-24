package aes;

import java.security.SecureRandom;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.engines.RijndaelEngine;
import org.bouncycastle.crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.encoders.Base64;
import api.ICryptosystem;

public class AES extends ICryptosystem {

	public static byte[] generation(int length) {
		SecureRandom random = new SecureRandom();
		byte[] keyBytes = new byte[length];
		random.nextBytes(keyBytes);
		return keyBytes;
	}

	private static byte[] pass;
	private static String password;
	private static byte[] salt;
	private static int iterationCount = 10;
	public static String generate() {
		pass = generation(32);
		setPassword(new String(Base64.encode(pass)));
		salt = generation(10);
		return password;
		
	}
	public static String encrypt(String text) {

		PKCS12ParametersGenerator pGen = new PKCS12ParametersGenerator(new SHA3Digest(256));

		pGen.init(pass, salt, iterationCount);

		BlockCipher engine = new RijndaelEngine(256);
		CBCBlockCipher cbc = new CBCBlockCipher(engine);
		BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(cbc, new PKCS7Padding());

		ParametersWithIV aesCBCParams = (ParametersWithIV) pGen.generateDerivedParameters(256, 256);
		cipher.init(true, aesCBCParams);

		byte[] input = text.getBytes();
		byte[] cipherText = new byte[cipher.getOutputSize(input.length)];

		int cipherLength = cipher.processBytes(input, 0, input.length, cipherText, 0);
		try {
			cipher.doFinal(cipherText, cipherLength);
		} catch (DataLengthException | IllegalStateException | InvalidCipherTextException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String result = new String(Base64.encode(cipherText));
		return result;
		
	}

	public static String decrypt(String text) {
		PKCS12ParametersGenerator pGen = new PKCS12ParametersGenerator(new SHA3Digest(256));

		pGen.init(pass, salt, iterationCount);

		BlockCipher engine = new RijndaelEngine(256);
		CBCBlockCipher cbc = new CBCBlockCipher(engine);
		BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(cbc, new PKCS7Padding());

		ParametersWithIV aesCBCParams = (ParametersWithIV) pGen.generateDerivedParameters(256, 256);
		cipher.init(false, aesCBCParams);

		byte[] output = Base64.decode(text.getBytes());
		byte[] cipherText = new byte[cipher.getOutputSize(output.length)];

		int cipherLength = cipher.processBytes(output, 0, output.length, cipherText, 0);
		int outputLength = 0;
		try {
			outputLength = cipher.doFinal(cipherText, cipherLength);
		} catch (DataLengthException | IllegalStateException | InvalidCipherTextException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outputLength += cipherLength;

		byte[] resultBytes = cipherText;
		if (outputLength != output.length) {
			resultBytes = new byte[outputLength];
			System.arraycopy(cipherText, 0, resultBytes, 0, outputLength);
		}

		String result = new String(resultBytes);
		return result;
	}

	public String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		AES.password = password;
	}
}
