package beans.views;

import beans.models.Ticket;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TicketsPdfView extends AbstractPdfView {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy/M/d HH:mm");

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
        throws Exception {

        @SuppressWarnings("unchecked")
        List<Ticket> tickets = (List<Ticket>) model.get("bookedTickets");
        Objects.requireNonNull(tickets, "'tickets' must not be null");
        PdfPTable table = new PdfPTable(4);
        table.setWidths(new int[]{25, 35, 15, 25});

        table.addCell("Event");
        table.addCell("Seats");
        table.addCell("Price");
        table.addCell("Date");

        for (Ticket ticket : tickets) {
            table.addCell(ticket.getEvent().getName());
            table.addCell(ticket.getSeats());
            table.addCell(String.valueOf(ticket.getPrice()));
            table.addCell(ticket.getDateTime().format(DATE_FORMAT));
        }

        document.add(table);
    }

}
