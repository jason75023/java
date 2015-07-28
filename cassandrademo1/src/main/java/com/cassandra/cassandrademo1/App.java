package com.cassandra.cassandrademo1;

import java.util.List;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class App {
public static void main(String[] args) {
Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").withPort(9042).build();
Session session = cluster.connect();

System.out.println("session object---" + session);

session.execute("use cassand");

//ResultSet resultSet = session.execute("select * from users where id='user1'");
ResultSet resultSet = session.execute("select * from users");

List<Row> results = resultSet.all();



for (Row row : results) {
//System.out.println(row.getInt(0));
//System.out.println(row.getString(4));	
//System.ouSystem.out.t.println(row.getString(1));
System.out.printf("id: %s; email: %s; name: %s; password: %s; type: %s\n",row.getString("id"),row.getString("email"),row.getString("name"),row.getString("password"),row.getString("type"));
}

session.close();
}
}