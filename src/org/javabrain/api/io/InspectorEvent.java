package org.javabrain.api.io;

/***
 * @author Fernando García
 * @version 0.0.1
 */
public interface InspectorEvent {

    void onCreate(File file);

    void onModify(File file);

    void onDelete(File file);
}
