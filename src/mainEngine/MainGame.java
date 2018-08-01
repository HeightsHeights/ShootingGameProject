package mainEngine;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import renderEngine.Renderer;

public class MainGame {

	private static final int WINDOW_PRIMARY_WIDTH = 640;
	private static final int WINDOW_PRIMARY_HEIGHT = 480;
	private static long window;
	private static Renderer renderer;

	public static void main(String[] args) {
		init();
		gameloop();
		cleanup();
	}

	/////////////////////////////////////////////////////////
	// 初期化処理
	/////////////////////////////////////////////////////////
	public static void init() {
		if (!glfwInit()) {
			throw new IllegalStateException("Failed to initialize glfw");
		}

		window = glfwCreateWindow(WINDOW_PRIMARY_WIDTH, WINDOW_PRIMARY_HEIGHT, "Shooting", 0, 0);
		if (window == 0) {
			throw new IllegalStateException("Failed to create window");
		}
		glfwMakeContextCurrent(window);

		GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, (videoMode.width() - WINDOW_PRIMARY_WIDTH) / 2,
				(videoMode.height() - WINDOW_PRIMARY_HEIGHT) / 2);
		glfwShowWindow(window);

		GL.createCapabilities();
		renderer = new Renderer();
	}

	/////////////////////////////////////////////////////////
	// ゲームループ
	/////////////////////////////////////////////////////////
	public static void gameloop() {
		while (!glfwWindowShouldClose(window)) {

			renderer.prepare();
			renderer.render();

			glfwSwapBuffers(window);
			glfwWaitEvents();
		}
	}

	/////////////////////////////////////////////////////////
	// 終了処理
	/////////////////////////////////////////////////////////
	public static void cleanup() {
		glfwDestroyWindow(window);
		glfwTerminate();
	}

}
