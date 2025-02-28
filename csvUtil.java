package com.docmosis.docmosis;

import com.docmosis.docmosis.Model.Temp_data;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class csvUtil {
    private static final CsvMapper mapper = new CsvMapper();

    public List<Temp_data> read(InputStream stream) throws IOException {
        CsvSchema.Builder schemaBuilder = CsvSchema.builder()
//                .addColumn("name")
                .addColumn("age")
                .addColumn("Gender")
                .addColumn("phoneNo")
                .addColumn("email")
                .setUseHeader(true);

        CsvSchema schema = schemaBuilder.build().withColumnReordering(true);

        ObjectReader reader = mapper.readerFor(Temp_data.class).with(schema);
        return reader.<Temp_data>readValues(stream).readAll();
    }
}