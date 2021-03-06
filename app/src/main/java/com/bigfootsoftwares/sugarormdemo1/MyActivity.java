package com.bigfootsoftwares.sugarormdemo1;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.orm.SugarRecord;
import com.orm.query.Condition;
import com.orm.query.Select;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.orm.SugarRecord.deleteAll;
import static com.orm.SugarRecord.save;


import java.util.List;

public class MyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        // first lets delete all existing record
        SugarRecord.deleteAll(Book.class);

        // creating new entries
        Book book = new Book(1,"Title here", "2nd edition");
        Book book1 = new Book(2,"Second Title", "3rd edition");
        Book book2 = new Book(3, "Third Title", "4rd edition");
        save(book);
        save(book1);
        save(book2);

        // view all records
        List<Book> books = Select.from(Book.class).list();
        Log.e("books",books.toString());

        // selection using where clause
        List<Book> where_books = Select.from(Book.class)
                .where(Condition.prop("edition").eq("2nd edition"))
                .list();

        Log.e("where clause books",where_books.toString());

        //updating the entry based on id
        Book bookn = new Book(3, "Third Title revised ", "4rd edition");
        save(bookn);

        // Deleting rows conditional
        deleteAll(Book.class, String.format("edition == '%s'","2nd edition"));

        asyncdemo();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void asyncdemo()
    {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://pos.nepalinn.com/eposapi/floortable", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                // here you get the json array
                Log.e("info",response.toString());
                super.onSuccess(statusCode, headers, response);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {

                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {

                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

                super.onFailure(statusCode, headers, responseString, throwable);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {

                super.onSuccess(statusCode, headers, responseString);
            }


        });
    }


}
