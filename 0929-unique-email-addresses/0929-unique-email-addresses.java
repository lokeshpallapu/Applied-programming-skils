class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        
        for (String email : emails) {
            int atIndex = email.indexOf('@');
            String local = email.substring(0, atIndex);
            String domain = email.substring(atIndex);
            
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            
            local = local.replace(".", "");
            uniqueEmails.add(local + domain);
        }
        
        return uniqueEmails.size();
    }
}