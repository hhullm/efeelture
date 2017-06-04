package util;

/**
 * @author zs
 * 
 * 主键生成
 *
 */
import java.util.UUID;

public class PKUtil {
	public static String getRandomPk() {
		String pk = UUID.randomUUID().toString();
		pk = pk.replaceAll("-", "").substring(0, 16);
		return pk;
	}

}
