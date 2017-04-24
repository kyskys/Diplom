package api;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

public abstract class ICryptosystem {

	public static String encrypt(String text) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
		return null;
	}

	public static String decrypt(String text) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
		return null;
	}

	byte[] generation(int length) {
		return null;
	}
}
