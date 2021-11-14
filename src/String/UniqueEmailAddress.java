package String;

import java.util.HashSet;
import java.util.Set;

/*
* https://leetcode.com/problems/unique-email-addresses/
*
*
*  */

public class UniqueEmailAddress {

    public static void main(String[] args) {
        UniqueEmailAddress a = new UniqueEmailAddress();
        String[] emails = {
                "test.email+james@coding.com",
                "test.e.mail+toto.jane@cod.ing.com",
                "testemail+tom@cod.ing.com" };
        System.out.println(a.solve_1(emails));
        System.out.println(a.solve_split(emails));

    }
    //1.Basic
    public int solve_1(String[] emails) {
        // 1 unique 해야햐기때문에 HashSet 사용
        Set<String> set = new HashSet<>();

        // 2
        for (String email : emails) {
            String localName = makeLocalName(email);// testemail
            String domainName = makeDomainName(email);// @
            System.out.println("domainName" + domainName);
            set.add(localName + "@" + domainName);
        }
        return set.size();
    }

    private String makeLocalName(String email) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < email.length(); i++) {
            // . 은 continue로 뺀다.
            if (email.charAt(i) == '.') {
                continue;
            }
            //  + 는 break로 뺀다.
            if (email.charAt(i) == '+') {
                break;
            }
            //  @ 는 break로 뺀다.
            if (email.charAt(i) == '@') {
                break;
            }
            // 2
            String str = String.valueOf(email.charAt(i));
            sb.append(str);
        }
        return sb.toString();
    }

    private String makeDomainName(String email) {

        return email.substring(email.indexOf('@') + 1);
    }



    //2 substring
    // index를 찾아서 substring 하는데, a@coding.com은 안된다. 다시 고민해봐야한다.
    public int solve_substring(String[] emails) {

        int result = 0;
        Set<String> set = new HashSet<>();
//		for (String email : emails) {
//			String tmpLocal = makeLocalName(email);
//			String tmpDomain = makeDomainName(email);
//			set.add(tmpLocal + tmpDomain);
//		}
        for (int i = 0; i < emails.length; i++) {
            String localName = "";
            String domainName = "";
            localName = emails[i].substring(0, emails[i].indexOf("+")).replace(".", "");
            domainName = emails[i].substring(emails[i].indexOf("@"));
            set.add(localName + domainName);
        }
        result = set.size();
        return result;

    }
    // 3 split
    public int solve_split(String[] emails) {

        // ds는 hashset를 이용
        Set<String> set = new HashSet<>();

        // for, while에서 split을 사용
        for (String email : emails) {
            // email에서 @를 기준으로 분리한다. 배열로 나눠서 저장
            String[] parts = email.split("@");
            // 그냥 + 구문을 쓰면 Dangling 에러가 나므로 \\+를 사용해서 분리.
            String[] localName = parts[0].split("\\+");
            // 여기서 또 . 을 replace로 제거해준다.
            // 그리고 나서 @와 원래 @ 이후를 붙여준다.
            set.add(localName[0].replace(".", "") + "@" + parts[1]); 														// domain.
        }
        return set.size();
    }
}
