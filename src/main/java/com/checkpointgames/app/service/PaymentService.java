
package com.checkpointgames.app.service;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.net.MPSearchRequest;
import com.mercadopago.resources.payment.Payment;
import com.mercadopago.net.MPResultsResourcesPage;
import com.mercadopago.resources.preference.Preference;
import com.mercadopago.client.payment.PaymentClient;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    
    private final PaymentClient paymentClient;
    
    public PaymentService() {      
        this.paymentClient = new PaymentClient();
    }

    @Configuration
    public class MercadoPagoConfigClass {

        public MercadoPagoConfigClass(@Value("${mercadopago.access-token}") String accessToken) {
            MercadoPagoConfig.setAccessToken(accessToken);
        }
    }
    
    @PostConstruct
    public void init(){
        com.mercadopago.MercadoPagoConfig.setAccessToken("APP_USR-6566681641810313-101619-3ab16efc83a9c80364a5bde439a5b779-2930383864");
    }

    public String createCheckoutPreference(Integer orderId, String title, Integer quantity, BigDecimal value) throws Exception {

        // ITEM
        PreferenceItemRequest item = PreferenceItemRequest.builder()
                .title(title)
                .quantity(quantity)
                .unitPrice(value) 
                .currencyId("BRL") // opcional, mas recomendado
                .build();

        // REQUEST
        PreferenceRequest request = PreferenceRequest.builder()
                .externalReference(String.valueOf(orderId)) 
                .notificationUrl("https://seusite.com/webhook/mercadopago")
                .items(List.of(item))
                .build();

        // CLIENT
        PreferenceClient client = new PreferenceClient();

        // CREATE PREF
        Preference preference = client.create(request);

        return preference.getInitPoint();
    }
    
    public void verificarPagamento(String preferenceId) throws MPException, MPApiException {
        // Criar filtros para buscar pagamentos por preference_id
        Map<String, Object> filtros = new HashMap<>();
        filtros.put("preference_id", preferenceId);

        // Montar a requisição de busca
        MPSearchRequest request = MPSearchRequest.builder()
                .filters(filtros)
                .limit(50)  // opcional
                .offset(0)  // opcional
                .build();

        // Buscar pagamentos
        MPResultsResourcesPage<Payment> page = paymentClient.search(request);
        List<Payment> pagamentos = page.getResults();

        // Verificar se existe algum pagamento
        if (pagamentos.isEmpty()) {
            System.out.println("Nenhum pagamento encontrado ainda para esta preferência.");
        } else {
            for (Payment p : pagamentos) {
                System.out.println("=== Pagamento Encontrado ===");
                System.out.println("Payment ID: " + p.getId());
                System.out.println("Status: " + p.getStatus());             // approved, pending, rejected
                System.out.println("Detalhes do Status: " + p.getStatusDetail());
                System.out.println("Valor pago: " + p.getTransactionAmount());
                System.out.println("Método de pagamento: " + p.getPaymentMethodId());
            }
        }
    }
    
}
    
