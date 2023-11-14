package io.ince.vms.datamangodb.constants;

public class Constants {
    public static final String DATA_ERROR = """
            {
                "message": "Unable to save request"
            }
            """;
    public static final String GET_DATA_ERROR = """
            {
                "message": "Unable to handle your request"
            }
            """;
    public static final String DATA_NOT_FOUND = """
            {
                "message": "Data not found"
            }
            """;
    public static final String BAD_PUT_REQUEST = """
            {
                "message": "Unable to update your request"
            }
            """;
}
