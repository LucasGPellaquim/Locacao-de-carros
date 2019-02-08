package app.util.json;

import flexjson.JSONSerializer;
import lombok.Getter;

@Getter
public class Json {

	private Object data;
	private JSONSerializer jsonSerializer;

	public Json(Object data) {

		this.data = data;
	}

	public Json(Object data, JSONSerializer jsonSerializer) {

		this.data = data;
		this.jsonSerializer = jsonSerializer;
	}


	public static class JsonMensagem {
		
		public String mensagem;
		public Object dados;
	}
}
