package renderEngine;

import org.lwjgl.opengl.GL11;
public class Renderer {
	public Renderer(){

		GL11.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
	}

	public void prepare() {

		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}

	public void render() {

	}
}
