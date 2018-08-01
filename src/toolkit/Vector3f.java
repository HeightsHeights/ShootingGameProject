package toolkit;

public class Vector3f {
	/////////////////////////////////////////////////////////
	// フィールド
	/////////////////////////////////////////////////////////
	private float x;
	private float y;
	private float z;

	/////////////////////////////////////////////////////////
	// セッターゲッター
	/////////////////////////////////////////////////////////
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	/////////////////////////////////////////////////////////
	// コンストラクタ
	/////////////////////////////////////////////////////////
	public Vector3f() {
		this(0, 0, 0);
	}

	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3f(Vector3f v) {
		this(v.x, v.y, v.z);
	}

	public Vector3f(float[] v) {
		this.x = (v.length >= 1) ? v[0] : 0;
		this.y = (v.length >= 2) ? v[1] : 0;
		this.z = (v.length >= 3) ? v[2] : 0;
	}

	/////////////////////////////////////////////////////////
	// 演算メソッド
	/////////////////////////////////////////////////////////
	public static Vector3f add(Vector3f left, Vector3f right) {
		return new Vector3f(left.x + right.x, left.y + right.y, left.z + right.z);
	}

	public static Vector3f sub(Vector3f left, Vector3f right) {

		return add(left, right.negate());
	}

	public static float angle(Vector3f left, Vector3f right) {
		float magnitude_l = left.length();
		float magnitude_r = right.length();
		if (magnitude_l != 0 && magnitude_r != 0) {
			return (float) Math.acos(dot(left, right) / (magnitude_l * magnitude_r));
		}
		return 0.0f;
	}

	public static float dot(Vector3f left, Vector3f right) {
		return left.x * right.x + left.y * right.y + left.z * right.z;
	}

	public static Vector3f cross(Vector3f left, Vector3f right) {
		return new Vector3f(left.y * right.z - left.z * right.y, left.z * right.x - left.x * right.z,
				left.x * right.y - left.y * right.x);
	}

	public Vector3f scale(float scale) {
		return new Vector3f(this.x * scale, this.y * scale, this.z * scale);
	}

	public Vector3f negate() {
		return this.scale(-1.0f);
	}

	public float lengthSquared() {
		return dot(this, this);
	}

	public float length() {
		return (float) Math.sqrt(this.lengthSquared());
	}

	public Vector3f normalize() {
		float magnitude = this.length();
		if (magnitude != 0) {
			return scale(1 / magnitude);
		}
		return this;
	}

	public Vector3f translate(float x, float y, float z) {
		return add(this, new Vector3f(x, y, z));
	}

	public Vector3f multiMatrix33(float[][] matrix) {
		return new Vector3f();
	}

	public Vector3f rotate(Vector3f v, float angle) {
		return new Vector3f();
	}

}
