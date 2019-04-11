package com.atoc.nrs.client;

import javax.ws.rs.core.MediaType;

import com.atoc.nrs.util.CodecUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient {

	public static String connectToProvider(String json){
		String url="http://localhost:2019/Providerapp/rest/empservice/insertEmp";
		String un="admin";
		String pwd="harsh";
		String msg=null;
		try {
			Client c=Client.create();
			WebResource r=c.resource(url);

			ClientResponse cr=r.type(MediaType.APPLICATION_JSON)
								.header("user",CodecUtil.doEncode(un))
								.header("password", CodecUtil.doEncode(pwd))
								.post(ClientResponse.class, json);
			msg=cr.getEntity(String.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return msg;
	}
}
