package polymorphism.assignment_practice;

import java.time.LocalDate;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected String subscriberName;
    protected LocalDate startDate;

    public SubscriptionPlan(String subscriberName, LocalDate startDate) {
        this.subscriberName = subscriberName;
        this.startDate = startDate;
    }

    public abstract int getValidityDays();

    public String getSubscriberName() { return subscriberName; }

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override
    public int getValidityDays() { return 30; }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override
    public int getValidityDays() { return 90; }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override
    public int getValidityDays() { return 365; }
}

public class StreamingPlanRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String planType = sc.next();
            String name = sc.next();
            String dateStr = sc.next();
            LocalDate startDate = LocalDate.parse(dateStr);

            SubscriptionPlan plan = null;
            if (planType.equalsIgnoreCase("BASIC")) {
                plan = new BasicPlan(name, startDate);
            } else if (planType.equalsIgnoreCase("STANDARD")) {
                plan = new StandardPlan(name, startDate);
            } else if (planType.equalsIgnoreCase("PREMIUM")) {
                plan = new PremiumPlan(name, startDate);
            }

            if (plan != null) {
                System.out.println(plan.getSubscriberName() + ": " + plan.calculateRenewalDate());
            }
        }
    }
}
