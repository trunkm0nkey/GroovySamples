//Couldn't find a Groovy LDAP library so this is mostly Java for now.

import javax.naming.Context
import javax.naming.NamingEnumeration
import javax.naming.directory.BasicAttributes
import javax.naming.directory.SearchControls
import javax.naming.directory.SearchResult
import javax.naming.ldap.InitialLdapContext
import javax.naming.ldap.LdapContext

def ldapUrl = "ldap://ldap.example.org:389"
def ldapAuthType = "simple"
def ldapDn = "uid=admin,ou=People,dc=example,dc=org"
def ldapPass = "XXXXXXXXXXXX"
def ldapBase = "ou=People,dc=example,dc=org"
def ldapFilter = "uid=joeblow"
def ldapAttrs = (String[]) ["uid","cn","mail"]

Hashtable<String, Object> env = new Hashtable<String, Object>()
env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory")
env.put(Context.PROVIDER_URL, ldapUrl)
env.put(Context.SECURITY_AUTHENTICATION, ldapAuthType)
env.put(Context.SECURITY_PRINCIPAL, ldapDn)
env.put(Context.SECURITY_CREDENTIALS, ldapPass)

LdapContext ctx  = new InitialLdapContext(env)
SearchControls sc = new SearchControls()
sc.setReturningAttributes(ldapAttrs)
sc.setSearchScope(SearchControls.SUBTREE_SCOPE)

NamingEnumeration results = ctx.search(ldapBase,ldapFilter,sc)
//Loop through all returned attrs
while (results) {
  SearchResult sr = (SearchResult) results.next()
  BasicAttributes srAttr = sr.getAttributes()
  //print
  println sr.getName()
  println srAttr.size()
  srAttr.each {
    println it
  }
//Print mail attr
  println srAttr.get("mail")
}

ctx.close()